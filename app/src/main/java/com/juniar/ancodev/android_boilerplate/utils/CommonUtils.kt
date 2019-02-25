package com.juniar.ancodev.android_boilerplate.utils

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.transform(): Observable<T> {
    return this.observeOn(AndroidSchedulers.mainThread())
        .onErrorResumeNext(Function { Observable.error(it) })
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.uiSubscribe(
    onNext: (T) -> Unit, onError: (Throwable) -> Unit,
    onCompleted: () -> Unit = {}
): Disposable {
    return this.transform().toFlowable(BackpressureStrategy.BUFFER)
        .subscribe({
            onNext(it)
        }, {
            onError(it)
        }, {
            onCompleted.invoke()
        })
}

fun Context.showToast(message: String, isLong: Boolean = false) = Toast.makeText(
    this, message, if (isLong) {
        Toast.LENGTH_LONG
    } else {
        Toast.LENGTH_SHORT
    }
).show()

fun Context.getColorCompat(@ColorRes colorId: Int) = ContextCompat.getColor(this, colorId)

fun Context.buildAlertDialog(
    title: String,
    message: String = "",
    yesButton: String = "",
    noButton: String = "",
    positiveAction: (DialogInterface) -> Unit = {},
    negativeAction: (DialogInterface) -> Unit = {}
): AlertDialog {
    val builder = AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)

    if (yesButton.isNotEmpty()) {
        builder.setPositiveButton(yesButton) { dialog, _ -> positiveAction.invoke(dialog) }
    }

    if (noButton.isNotEmpty()) {
        builder.setNegativeButton(noButton) { dialog, _ -> negativeAction.invoke(dialog) }
    }

    return builder.create()
}

fun Context.checkRequestPermission(permission: String): Boolean {
    return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Activity.makeRequest(permission: String, requestCode: Int) {
    ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
}

val sdkVersion = Build.VERSION.SDK_INT