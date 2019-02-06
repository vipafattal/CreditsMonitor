package com.magenta.creditsmonitor.framework.utils.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

fun <T: ViewModel> Fragment.viewModelOf(viewModelClass: Class<T>)=
    ViewModelProviders.of(activity!!).get(viewModelClass)
