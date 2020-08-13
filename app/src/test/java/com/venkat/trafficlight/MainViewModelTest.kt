package com.venkat.trafficlight

import android.os.Handler
import android.os.Looper
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    lateinit var mainViewModel: MainViewModel

    @Before
    fun setUp() {
        mainViewModel = MainViewModel()
    }

    @Test
    fun validate_ready()
    {
        mainViewModel.ready("Go")
        assertTrue(mainViewModel.isReady.get())
        assertFalse(mainViewModel.isGo.get())
        assertFalse(mainViewModel.isStop.get())
    }
    @Test
    fun validate_go()
    {
        mainViewModel.ready("Go")
        assertTrue(mainViewModel.isReady.get())
        Handler(Looper.getMainLooper()).postDelayed({
            assertFalse(mainViewModel.isReady.get())
            assertTrue(mainViewModel.isGo.get())
        },1000)

    }
    @Test
    fun validate_stop()
    {
        mainViewModel.ready("Stop")
        assertTrue(mainViewModel.isReady.get())
        Handler(Looper.getMainLooper()).postDelayed({
            assertFalse(mainViewModel.isReady.get())
            assertTrue(mainViewModel.isStop.get())
        },1000)

    }
    @After
    fun tearDown() {
    }
}