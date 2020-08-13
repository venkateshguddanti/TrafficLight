package com.venkat.trafficlight

import android.graphics.drawable.Drawable
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("android:background")
fun setBackground(view: View, drawable: Drawable?) {
    if (VERSION.SDK_INT >= VERSION_CODES.JELLY_BEAN) {
        view.background = drawable
    } else {
        view.setBackgroundDrawable(drawable)
    }
}