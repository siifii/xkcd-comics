package com.siifii.xkcd_comics.core.extension

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.like.LikeButton
import com.like.OnLikeListener

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


    @BindingAdapter("isBookmarked")
    @JvmStatic
    fun setBookmark(likeButton: LikeButton, isBookmarked: Boolean? = false) {
        isBookmarked?.let { likeButton.isLiked = it }
    }

    @BindingAdapter("onLikeClicked")
    @JvmStatic
    fun onLikeClicked(view: LikeButton, clickListener: View.OnClickListener) {
        view.setOnLikeListener(object : OnLikeListener {
            override fun liked(likeButton: LikeButton?) {
                clickListener.onClick(view)
            }

            override fun unLiked(likeButton: LikeButton?) {
                clickListener.onClick(view)
            }
        })
    }
}