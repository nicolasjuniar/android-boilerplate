package com.juniar.ancodev.android_boilerplate.utils

import android.content.Context
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.juniar.ancodev.android_boilerplate.R

fun View.gone() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}

fun Context.showSnackBar(
    view: View,
    text: String,
    duration: Int = Snackbar.LENGTH_INDEFINITE,
    textColor: Int = ContextCompat.getColor(this, R.color.Red),
    dismissEvent: () -> Unit = {}
) {
    val snackbar = Snackbar.make(view, text, duration)
    snackbar.setAction(android.R.string.ok) { snackbar.dismiss() }
    snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.Gray))
    snackbar.duration = 4000
    snackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.White))
    snackbar.setActionTextColor(textColor)
    snackbar.show()
    snackbar.addCallback(object : Snackbar.Callback() {
        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
            super.onDismissed(transientBottomBar, event)
            dismissEvent.invoke()
        }
    })
}

val DONT_TOUCH = WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE

fun EditText.textToString() = this.text.toString()