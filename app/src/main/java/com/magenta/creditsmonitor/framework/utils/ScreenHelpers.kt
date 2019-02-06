package com.magenta.creditsmonitor.framework.utils

import android.util.DisplayMetrics
import android.util.TypedValue
import com.magenta.creditsmonitor.framework.AppMain.Companion.appMainContext

/**
 * Created by ${User} on ${Date}
 */

private var dm: DisplayMetrics = appMainContext.resources.displayMetrics

val screenWidth: Int = dm.widthPixels
val screenHeight: Int = dm.heightPixels

fun dp(px: Float): Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, px,
    appMainContext.resources.displayMetrics
).toInt()