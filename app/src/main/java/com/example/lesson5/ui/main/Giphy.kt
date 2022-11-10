package com.example.lesson5.ui.main

import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("data")
    lateinit var data: List<Image>
    fun data(): List<Image> = data
}

//data class Data(
//    @SerializedName("images") var image: Image
//)

data class Image(
    @SerializedName("original") var original: Original

)

data class Original (
    @SerializedName("original") var url: String = ""
)
