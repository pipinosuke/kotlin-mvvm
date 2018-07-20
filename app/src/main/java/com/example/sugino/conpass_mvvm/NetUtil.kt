package com.example.sugino.conpass_mvvm

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetUtil {

    val conpassClient: ConpassClient
       get() = retrofit!!.create(ConpassClient::class.java)


    private var retrofit: Retrofit? = null
    get() {
        field = field ?: setUpRetrofit()
        return field
    }

    private fun setUpRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://connpass.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}