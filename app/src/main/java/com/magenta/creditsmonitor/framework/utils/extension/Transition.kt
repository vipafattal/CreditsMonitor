package com.magenta.creditsmonitor.framework.utils.extension

import android.content.Context
import android.os.Build
import android.transition.TransitionInflater
import androidx.annotation.RequiresApi
import androidx.annotation.TransitionRes
import androidx.fragment.app.Fragment
import com.magenta.creditsmonitor.framework.AppMain.Companion.appMainContext

/**
 * Created by ${User} on ${Date}
 */

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun Fragment.transitionAnimator(@TransitionRes enterRes:Int, @TransitionRes exitRes:Int){
    val enterTransition = TransitionInflater.from(appMainContext)
        .inflateTransition(enterRes)
    val exitTransition = TransitionInflater.from(appMainContext)
        .inflateTransition(exitRes)

    sharedElementEnterTransition = enterTransition
    sharedElementReturnTransition = exitTransition
}