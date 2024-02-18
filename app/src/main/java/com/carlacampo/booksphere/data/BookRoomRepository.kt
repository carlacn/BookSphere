package com.carlacampo.booksphere.data

import android.util.Log
import com.carlacampo.booksphere.bbdd.roomBookdb.BookDao
import com.carlacampo.booksphere.bbdd.roomBookdb.toDomain
import javax.inject.Inject

class BookRoomRepository @Inject constructor(

    private val bookDao: BookDao
) {

    fun getBooks(): List<Book> {
        Log.d("BookRoomRepository", "getBooks: ")
        val books = bookDao.getAll().map { it.toDomain() }
        Log.d("BookRoomRepository", "getBooks: FINISHED $books")
        return books
    }

    fun saveBook(book: Book) = bookDao.insertAll(book.toEntity())

}