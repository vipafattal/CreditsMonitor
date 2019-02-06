package com.magenta.creditsmonitor.framework

import android.app.Application
import android.preference.PreferenceManager
import androidx.core.content.edit
import com.magenta.creditsmonitor.R
import com.magenta.creditsmonitor.framework.utils.delegation.DelegatesExt


/**
 * Created by ${User} on ${Date}
 */
class AppMain : Application() {
    companion object {
        var appMainContext: AppMain by DelegatesExt.notNullSingleValue()
            private set
    }

    val mSharedPrefs by lazy {
        PreferenceManager.getDefaultSharedPreferences(appMainContext)!!
    }

    var isNightModeEnabled = false
        get() {
            return mSharedPrefs.getBoolean(NIGHT_MODE_KEY, false)
        }
        set(value) {
            field = value
            mSharedPrefs.edit {
                putBoolean(NIGHT_MODE_KEY, value)
            }
        }


    fun changeThemeMode() {
        isNightModeEnabled = !isNightModeEnabled
    }

    fun getAppTheme(): Int =
        if (isNightModeEnabled)
            R.style.AppTheme_Dark
        else
            R.style.AppTheme_Light

    fun getThemeIcon():Int =
        if (isNightModeEnabled)
            R.drawable.ic_moon
        else
            R.drawable.ic_sun

    override fun onCreate() {
        super.onCreate()
        appMainContext = this
    }

}
