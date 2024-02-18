package com.carlacampo.booksphere.bbdd.roomBookdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
    @Query("SELECT * FROM BookEntity")
    fun getAll(): List<BookEntity>

    @Insert
    fun insertAll(vararg book: BookEntity)

    @Delete
    fun delete(book: BookEntity)
}