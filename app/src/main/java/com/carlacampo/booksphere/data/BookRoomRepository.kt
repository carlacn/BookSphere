package com.carlacampo.booksphere.data

import android.util.Log
import com.carlacampo.booksphere.api.CatFactResponse
import com.carlacampo.booksphere.api.CatsApi
import com.carlacampo.booksphere.bbdd.roomBookdb.BookDao
import com.carlacampo.booksphere.bbdd.roomBookdb.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject


class BookRoomRepository @Inject constructor(

    private val bookDao: BookDao,
    private val api: CatsApi
) {

    fun getBooks(): List<Book> {
        Log.d("BookRoomRepository", "getBooks: ")
        val books = bookDao.getAll().map { it.toDomain() }
        Log.d("BookRoomRepository", "getBooks: FINISHED $books")
        return books
    }

    suspend fun saveBook(book: Book) {
        Log.d("BookRoomRepository", "saveBook: $book")
        bookDao.insertAll(book.toEntity())
    }

    //API
    suspend fun getCatsFact() {
        withContext(Dispatchers.IO) {
            val fact: CatFactResponse = api.getCatsFact().await()
            Log.d("BookRoomRepository", "getCatsFact: $fact")
        }
    }

}


