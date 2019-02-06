package com.magenta.creditsmonitor.framework.utils.extension

import android.animation.ValueAnimator
import androidx.cardview.widget.CardView
import com.magenta.creditsmonitor.R

/**
 * Created by ${User} on ${Date}
 */

fun CardView.animateElevation(animateOut: Boolean) {
    val elevation = resources.getDimension(R.dimen.toolbar_elevation)
    var endElevation = elevation
    var startElevation = 0f

    if (animateOut) {
        startElevation = elevation
        endElevation = 0f
    }
    ValueAnimator().apply {
        duration = 250
        setFloatValues(startElevation,endElevation)
        setTarget(this)
        start()
    }.addUpdateListener {
        cardElevation =  it.animatedValue as Float
    }


}