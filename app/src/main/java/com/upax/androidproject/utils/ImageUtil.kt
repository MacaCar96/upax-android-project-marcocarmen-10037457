package com.upax.androidproject.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageUtil {

    fun load(imageView: ImageView, source: String) {
        Glide.with(imageView).load(source).into(imageView)
    }

}