package com.magenta.creditsmonitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.magenta.creditsmonitor.fragments.CreditsFragment
import com.magenta.creditsmonitor.fragments.OnBackPressedListener
import com.magenta.creditsmonitor.framework.AppMain.Companion.appMainContext
import com.magenta.creditsmonitor.framework.utils.extension.replaceFragment

class MainActivity : AppCompatActivity() {

    private val creditsFragment = CreditsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(appMainContext.getAppTheme())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.findFragmentByTag(CreditsFragment.TAG) ?:
        replaceFragment(creditsFragment, R.id.fragment_container,CreditsFragment.TAG)
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.primaryNavigationFragment
        (fragment as? OnBackPressedListener)?.onFragmentBackPressed()
            ?: super.onBackPressed()
    }
}
