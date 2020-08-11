package com.venkat.trafficlight

class SignalRed : Color() {
    override fun displayDuration(): Long {
        return 4000
    }
}