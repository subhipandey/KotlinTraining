package com.subhipandey

import android.os.Build

actual fun platformName(): String {
    return "Android ${Build.VERSION.RELEASE}"

}