package com.carlacampo.booksphere.bbdd.roomBookdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.carlacampo.booksphere.data.Book

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "publicationYear") val publicationYear: Int,
    @ColumnInfo(name = "editorial") val editorial: String,
    @ColumnInfo(name = "pages") val pages: Int
    )


    fun BookEntity.toDomain() = Book(
        title = title,
        author = author,
        publicationYear = publicationYear,
        editorial = editorial,
        pages = pages
    )