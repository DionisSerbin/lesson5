package com.example.lesson5.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.lesson5.R

class GifAdapter : ListAdapter<Image, GifViewHolder>(GifDiffitemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return GifViewHolder(view)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val cat = getItem(position)
        holder.bind(cat)
    }
}