package com.celaloglu.zafer.commons

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.celaloglu.zafer.R
import com.google.android.material.snackbar.Snackbar

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun showSnackbar(view: View, message: String) {
    val snack = Snackbar.make(
        view,
        message,
        Snackbar.LENGTH_LONG
    )
    val view = snack.view
    val params = view.layoutParams as FrameLayout.LayoutParams
    params.gravity = Gravity.TOP
    view.layoutParams = params
    snack.show()
}

fun RecyclerView.initRecyclerViewWithLineDecoration(context: Context) {
    val linearLayoutManager = LinearLayoutManager(context)
    val itemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
    layoutManager = linearLayoutManager
    addItemDecoration(itemDecoration)
}

