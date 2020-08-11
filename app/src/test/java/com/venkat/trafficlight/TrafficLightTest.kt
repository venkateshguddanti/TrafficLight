package com.venkat.trafficlight

import android.os.Build
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Switch
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class TrafficLightTest {
    lateinit var activity: MainActivity
    val handler = Handler(Looper.getMainLooper())

    @Before
    fun setUp()
    {
        val  controller = Robolectric.buildActivity(MainActivity::class.java)
        activity = controller.create().start().resume().visible().get()
    }
    @Test
    fun validateGreenSignal()
    {
        val yellow = activity.findViewById<Button>(R.id.yellow)
        val green = activity.findViewById<Button>(R.id.green)
        val switch = activity.findViewById<Switch>(R.id.onOffSwitch)
        assertFalse(switch.isChecked)
        switch.toggle()
        assertTrue(switch.isChecked)
        handler.postDelayed(Runnable {
            assertEquals(
                R.drawable.circular_bg_orange,
                shadowOf(yellow.background).createdFromResId
            )
            handler.postDelayed(Runnable {
                assertEquals(
                    R.drawable.circular_bg_green,
                    shadowOf(green.background).createdFromResId
                )
            },4000)

        },1000)

    }
    @Test
    fun validateRedSignal() {
        val yellow = activity.findViewById<Button>(R.id.yellow)
        val red = activity.findViewById<Button>(R.id.red)
        val switch = activity.findViewById<Switch>(R.id.onOffSwitch)
        assertFalse(switch.isChecked)
        switch.toggle()
        assertTrue(switch.isChecked)
        switch.toggle()
        handler.postDelayed(Runnable {
            assertEquals(
                R.drawable.circular_bg_orange,
                shadowOf(yellow.background).createdFromResId
            )
            handler.postDelayed(Runnable {
                assertEquals(
                    R.drawable.circular_bg_red,
                    shadowOf(red.background).createdFromResId
                )
            },4000)

        },1000)
    }
    @After
    fun tearDown() {
        handler.removeCallbacksAndMessages(null)
    }

}
