package com.georgegtony.tunatheatre.helpers

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.georgegtony.tunatheatre.constants.AppConstants

class AppPreference(context: Context) {

    private val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(AppConstants.Prefs.PREFS_NAME, Context.MODE_PRIVATE)
    }


    var user_id: Int?
        get() = prefs.getInt(AppConstants.Prefs.USER_ID, 0)
        set(value) = prefs.edit { putInt(AppConstants.Prefs.USER_ID, value?:0) }

    var device_id: String?
        get() = prefs.getString(AppConstants.Prefs.DEVICE_ID, null)
        set(value) = prefs.edit { putString(AppConstants.Prefs.DEVICE_ID, value) }


}