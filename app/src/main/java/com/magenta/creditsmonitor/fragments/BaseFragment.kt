package com.magenta.creditsmonitor.fragments

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by ${User} on ${Date}
 */
abstract class BaseFragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(inflateViewId(),container,false)
    }
    abstract fun inflateViewId():Int
}