package com.example.tenant.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tenant.AppPreference
import com.example.tenant.R
import com.example.tenant.StatusBarManager
import com.example.tenant.databinding.ActivityCompanyBinding

class CompanyActivity : AppCompatActivity() {

    private var _binding: ActivityCompanyBinding? = null

    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private var isBackPressed = false

    companion object {
        var ISRTLLayout = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityCompanyBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        configurationChange()

        // Status bar
        StatusBarManager.changeStatusBarColor(this, window, R.color.blue)

        val preference = AppPreference.getInstance(this)
        setAppLanguage(preference.languageCode)

        //ADD navigation graph
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentMaintanceNav) as NavHostFragment
        navController = navHostFragment.navController

        _binding?.apply {
            bottomBar.selectedItemId = R.id.navHome // default selected item is HOME
            //setting bottom navigation bar with nav controller
            bottomBar.setupWithNavController(navController)
            bottomBar.setOnItemSelectedListener {
                isBackPressed = false
                when (it.itemId) {
                    R.id.navHome -> navController.navigate(R.id.homeFragment)
                    R.id.navProperty -> navController.navigate(R.id.propertyFragment)
                    R.id.navWorker -> navController.navigate(R.id.workerFragment)
                    R.id.nav_Language -> navController.navigate(R.id.languageFragment)
                }

                true
            }
        }
    }

    private fun configurationChange() {
        val rootView: View = findViewById(android.R.id.content)
        rootView.viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val currentLayoutDirection = rootView.layoutDirection

                ISRTLLayout = currentLayoutDirection != View.LAYOUT_DIRECTION_LTR

                // Remove the listener to avoid multiple calls
                rootView.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })
    }

    fun setAppLanguage(languageCode: String) {
        val appLocale: LocaleListCompat = LocaleListCompat.forLanguageTags(languageCode)
        // Call this on the main thread as it may require Activity.restart()
        AppCompatDelegate.setApplicationLocales(appLocale)
    }
}
