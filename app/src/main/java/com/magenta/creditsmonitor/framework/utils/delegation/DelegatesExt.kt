package com.magenta.creditsmonitor.framework.utils.delegation

import com.codebox.kidslab.framework.Delegation.NotNullSingleValueVar

object DelegatesExt {
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
}