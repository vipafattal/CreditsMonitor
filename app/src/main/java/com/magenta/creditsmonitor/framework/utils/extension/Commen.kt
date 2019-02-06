package com.magenta.creditsmonitor.framework.utils.extension

import android.os.Build

/**
 * Created by ${User} on ${Date}
 */

inline fun apiCall(version: Int, block: () -> Unit) {
    if (Build.VERSION.SDK_INT >= version){
        block()
    }
}