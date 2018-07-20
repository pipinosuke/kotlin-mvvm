package com.example.sugino.conpass_mvvm

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sugino.conpass_mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LifecycleOwner{

    private lateinit var mainViewModel: MainViewModel
//    private val eventListAdapter by lazy { MainRecyclerAdapter(this@MainActivity) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        lifecycle.addObserver(mainViewModel)

        mainViewModel.events.observe(this, Observer {
            //TODO
            // })
            binding.viewModel = mainViewModel
        })
    }
}