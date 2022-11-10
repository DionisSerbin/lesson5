package com.example.lesson5.ui.main

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class GifDiffitemCallback: DiffUtil.ItemCallback<Image>() {
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }
}