package com.carlacampo.booksphere.data

import com.carlacampo.booksphere.bbdd.roomBookdb.BookEntity

data class Book(
    val title: String,
    val author: String,
    val publicationYear: Int,
    val editorial:String,
    val pages:Int,
    //@DrawableRes var image:Int
    //val image: String
    )

    fun Book.toEntity() = BookEntity (
        title = title,
        author = author,
        publicationYear = publicationYear,
        editorial = editorial,
        pages = pages
    )




