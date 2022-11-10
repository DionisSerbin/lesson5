package com.example.lesson5.ui.main

class GifProvider(val accessor: IAccessor) {

    suspend fun getGiphy(api_key: String, rating: String, limit: Int): List<Image> {

        return accessor
            .getGiphy(rating = rating, limit = limit, apiKey = api_key).data()
    }
}