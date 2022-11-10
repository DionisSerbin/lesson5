package com.example.lesson5.ui.main

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson5.R
import com.squareup.picasso.Picasso

class GifViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected val image by lazy { view.findViewById<ImageView>(R.id.image) }
    protected val imageLoader by lazy { Picasso.get() }

    fun bind(giphy: Image) {
        println("!!!!!!!!!!!!!!!!!!!!")
        println(giphy)
        val url = giphy.original.url
        imageLoader.load(url).into(image)
    }
}