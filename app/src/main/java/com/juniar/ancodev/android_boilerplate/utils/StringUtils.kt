package com.juniar.ancodev.android_boilerplate.utils

import android.util.Patterns
import com.google.gson.Gson
import timber.log.Timber
import java.util.regex.Pattern

fun isPhoneValid(phone: String) = Patterns.PHONE.matcher(phone).matches()

fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()

fun String.logDebug() = Timber.d(this)

fun alphabetOnly(text: String): Boolean {
    val expression = "^[\\p{L} .'-]+$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(text)
    return matcher.matches()
}

fun Any.encodeJson() = Gson().toJson(this)