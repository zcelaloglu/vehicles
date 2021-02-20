package com.celaloglu.zafer.commons

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.celaloglu.zafer.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadUrl")
    fun loadImage(view: ImageView, url: String?) {
        url?.let {
            Glide.with(view.context)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .into(view)
        }
    }

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }
}