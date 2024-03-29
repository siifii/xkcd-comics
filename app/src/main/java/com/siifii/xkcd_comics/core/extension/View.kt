package com.siifii.xkcd_comics.core.extension

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

/*
Created by Kareem Alsaifi for  on 9/16/2021.
Copyright (c) 2021 . All rights reserved.
*/

fun Fragment.shareContent(title: String?, content: String?, uri: Uri? = null) {
    val share = Intent.createChooser(Intent().apply {
        type = "message/rfc822"
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TITLE, title)
        putExtra(Intent.EXTRA_TEXT, content)
    }, null)
    startActivity(share)
}

fun Context.shortToast(string: String) = Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
fun Context.longToast(string: String) = Toast.makeText(this, string, Toast.LENGTH_LONG).show()

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
