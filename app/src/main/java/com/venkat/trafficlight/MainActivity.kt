package com.venkat.trafficlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.venkat.trafficlight.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val GO = "Go"
    private val STOP = "Stop"
    lateinit var  mainViewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityBinding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
         mainViewModel =  ViewModelProvider(this).get(MainViewModel::class.java)
        activityBinding.viewmodel = mainViewModel

        onOffSwitch.setOnCheckedChangeListener { view, isCheckable->
            if (isCheckable) {
                view.text = GO
                mainViewModel.ready(GO)
            } else {
                view.text = STOP
                mainViewModel.ready(STOP)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        mainViewModel.mHandler.removeCallbacksAndMessages(null)
    }
}