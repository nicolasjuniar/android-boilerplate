package com.juniar.ancodev.android_boilerplate.utils

import android.content.Context
import android.content.SharedPreferences
import com.juniar.ancodev.android_boilerplate.common.Constant.String.Companion.EMPTY_STRING

class SharedPreferencesUtil(context: Context) {

    private val sharedPreferenceUtil: SharedPreferences =
        context.getSharedPreferences("boilerplate_preferences", Context.MODE_PRIVATE)

    fun setBoolean(key: String, value: Boolean) {
        sharedPreferenceUtil.edit().putBoolean(key, value).apply()
    }

    fun setString(key: String, value: String) {
        sharedPreferenceUtil.edit().putString(key, value).apply()
    }

    fun setInt(key: String, value: Int) {
        sharedPreferenceUtil.edit().putInt(key, value).apply()
    }

    fun setLong(key: String, value: Long) {
        sharedPreferenceUtil.edit().putLong(key, value).apply()
    }

    fun getBoolean(key: String) = sharedPreferenceUtil.getBoolean(key, false)

    fun getString(key: String, defaultValue: String = EMPTY_STRING) = sharedPreferenceUtil.getString(key, defaultValue)

    fun getInt(key: String, defaultValue: Int = 0) = sharedPreferenceUtil.getInt(key, defaultValue)

    fun getLong(key: String, defaultValue: Long) = sharedPreferenceUtil.getLong(key, defaultValue)
}