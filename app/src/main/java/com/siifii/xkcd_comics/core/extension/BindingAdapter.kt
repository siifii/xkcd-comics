package com.siifii.xkcd_comics.core.extension

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/*
Created by Kareem Alsaifi for  on 9/17/2021.
Copyright (c) 2021 . All rights reserved.
*/
object BindingAdapter {

    @BindingAdapter("loadImageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?) {
        Glide.with(view)
            .load(url)
            .apply(RequestOptions.fitCenterTransform())
            .into(view)
    }
}