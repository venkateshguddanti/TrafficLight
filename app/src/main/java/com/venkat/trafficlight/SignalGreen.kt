package com.venkat.trafficlight

class SignalGreen : Color() {
    override fun displayDuration(): Long {
        return 4000
    }
}