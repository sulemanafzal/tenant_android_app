package com.example.tenant

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class AppPreference {
    companion object {
        private val sharePref = AppPreference()
        private lateinit var sharedPreferences: SharedPreferences
        private val APP_THEME = "App_Theme"
        private val LANGUAGE = "language"

        private val USER_NAME= "USER_NAME"
        private val EMAIL = "EMAIL"
        private val USER_ID = "USER_ID"
        private val UUID = "UUID"
        private val MOBILE_NUM = "MOBILE_NUM"
        private val PROFILE_IMAGE = "PROFILE_IMAGE"
        private val PROFILE_THUMB_IMG = "PROFILE_THUMBNAIL"
        private val LOCATION_LATITIUDE = "LOCATION_LAT"
        private val LOCATION_LONGITUDE = "LOCATION_LONG"
        private val ADDRESS = "ADDRESS"
        private val COUNTRY = "COUNTRY"

        fun getInstance(context: Context): AppPreference {
            if (!::sharedPreferences.isInitialized) {
                synchronized(AppPreference::class.java) {
                    if (!::sharedPreferences.isInitialized) {
                        sharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
                    }
                }
            }
            return sharePref
        }
    }

    fun setAppTheme(isDarkMode: Boolean) {
        sharedPreferences.edit()
            .putBoolean(APP_THEME, isDarkMode)
            .apply()
    }

    val isDarkModeEnabled: Boolean get() = sharedPreferences.getBoolean(APP_THEME, false)

    fun setLanguageCode(languageCode: String) {
        sharedPreferences.edit()
            .putString(LANGUAGE, languageCode)
            .apply()
    }

    val languageCode: String get() = sharedPreferences.getString(LANGUAGE,"en")!!

    fun clearPreference() {
        sharedPreferences.edit().clear().apply()
    }

}