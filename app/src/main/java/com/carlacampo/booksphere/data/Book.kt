package com.carlacampo.booksphere.data

import androidx.annotation.DrawableRes

data class Book(
    val title: String,
    val author: String,
    val publicationYear: Int,
    val editorial:String,
    val pages:Int,
    @DrawableRes var image:Int
    ) {

}

