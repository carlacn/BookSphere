package com.carlacampo.booksphere.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.carlacampo.booksphere.api.CatFactResponse
import com.carlacampo.booksphere.api.CatsApi
import com.carlacampo.booksphere.bbdd.roomBookdb.BookDao
import com.carlacampo.booksphere.bbdd.roomBookdb.toDomain
import com.carlacampo.booksphere.di.BooksDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject


class BookRoomRepository @Inject constructor(

    private val bookDao: BookDao,
    private val api: CatsApi,
    @BooksDataStore private val booksDataStore: DataStore<Preferences>,
) {

    fun getBooks(): List<Book> {
        Log.d("BookRoomRepository", "getBooks: ")
        val books = bookDao.getAll().map { it.toDomain() }
        Log.d("BookRoomRepository", "getBooks: FINISHED $books")
        return books
    }

    //This fun save a book in Room and
    suspend fun saveBook(book: Book) {
        Log.d("BookRoomRepository", "saveBook: $book")
        bookDao.insertAll(book.toEntity())
        booksDataStore.edit { settings ->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
        }
    }

    //API
    suspend fun getCatsFact() {
        withContext(Dispatchers.IO) {
            val fact: CatFactResponse = api.getCatsFact().await()
            Log.d("BookRoomRepository", "getCatsFact: $fact")
        }
    }

    //DataStore - how to read from datastore
    //fun saveBook from this repo works for DataStore too
    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
    suspend fun getBooksDataStore(): Flow<Int> =
        booksDataStore.data
            .map { preferences ->
                // No type safety.
                preferences[EXAMPLE_COUNTER] ?: 0
            }
    }



