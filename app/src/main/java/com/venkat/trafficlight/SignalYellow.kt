package com.venkat.trafficlight

class SignalYellow : Color()
{
    override fun displayDuration(): Long {
        return 1000
    }
}