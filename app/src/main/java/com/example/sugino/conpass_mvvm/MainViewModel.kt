package com.example.sugino.conpass_mvvm

import android.arch.lifecycle.*
import android.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel: ViewModel(), LifecycleObserver {
    val events = MutableLiveData<ConpassEvent>()
    val isLoading = ObservableField<Boolean>(false)

    private val disposeBug = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getEventList() {
        NetUtil.conpassClient.event()
                .doOnSubscribe { isLoading.set(true) }
                .doFinally { isLoading.set(false) }
                .subscribeBy(
                        onNext = {
                            events.postValue(it)
                        }
                ).addTo(disposeBug)
    }

    override fun onCleared() {
        super.onCleared()
        disposeBug.clear()
    }
}