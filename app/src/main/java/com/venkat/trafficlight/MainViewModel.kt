package com.venkat.trafficlight

import android.os.Handler
import android.os.Looper
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val isStop : ObservableBoolean = ObservableBoolean(false)
    var isGo : ObservableBoolean = ObservableBoolean(false)
    val isReady : ObservableBoolean = ObservableBoolean(false)
    val mHandler = Handler(Looper.getMainLooper())

     private fun go() {
        isGo.set(true)
        mHandler.postDelayed({ isGo.set(false) },4000)
    }
    fun ready(type:String)
    {
        if(type == "Go") isStop.set(false) else isGo.set(false)
        isReady.set(true)
        mHandler.postDelayed({
            isReady.set(false)
            if(type == "Go") go() else stop()
        },1000)
    }

     private fun stop(){
        isStop.set(true)
        mHandler.postDelayed({ isStop.set(false) },4000)
    }


}