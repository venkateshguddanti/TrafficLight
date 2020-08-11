package com.venkat.trafficlight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val GO = "Go"
    private val STOP = "Stop"

    private val mHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onOffSwitch.setOnCheckedChangeListener { view, isCheckable->
            if (isCheckable) {
                view.text = GO
                switchLights()
            } else {
                view.text = STOP
                switchLights()
            }
        }
    }
    private fun switchLights() {
        mHandler.removeCallbacksAndMessages(null)
        if(onOffSwitch.text.equals(GO))
        {
            red.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_gray)
        }else
        {
            green.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_gray)
        }
        var perform = SignalYellow() as Color
        yellow.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_orange)
       mHandler.postDelayed(Runnable {
            yellow.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_gray)
           if (onOffSwitch.text.equals(GO)) {
               perform = SignalGreen()
               green.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_green)
               mHandler.postDelayed(Runnable {
                   green.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_gray)
                   onOffSwitch.isChecked = false
               },perform.displayDuration())
           } else {
               perform = SignalRed()
               red.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_red)
               mHandler.postDelayed(Runnable {
                   red.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_gray)
                   onOffSwitch.isChecked = true
               },perform.displayDuration())
           }
       },perform.displayDuration())

    }

    override fun onStop() {
        super.onStop()
        mHandler.removeCallbacksAndMessages(null)
    }

    override fun onResume() {
        super.onResume()
        red.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_gray)
        green.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_gray)
        yellow.background = ContextCompat.getDrawable(this,R.drawable.circular_bg_gray)
        onOffSwitch.isChecked = false
    }


}
