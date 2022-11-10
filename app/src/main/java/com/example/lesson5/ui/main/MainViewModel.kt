package com.example.lesson5.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val accessor = IAccessor.create()
    private val provider = GifProvider(accessor)

    suspend fun getGiphy() = provider.getGiphy(api_key = API_KEY, rating = "g", limit = 2)

    companion object {
        const val API_KEY = "yY5LAD1stQaVe3gw1Ct1aQ9Zv2HroMVe"
    }
}