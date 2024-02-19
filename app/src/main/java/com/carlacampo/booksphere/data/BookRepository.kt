package com.carlacampo.booksphere.data

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.carlacampo.booksphere.bbdd.BookDBScheme
import javax.inject.Inject

class BookRepository @Inject constructor(
//    private val api: PilasAPI,
//    private val sharedPreferences: SharedPreferences,
    private val  writableDB: SQLiteDatabase
){

    fun downloadBook(): List<Book> {
        var cursor = writableDB.query(
            BookDBScheme.TABLE_NAME,
/*            arrayOf(
                BaseColumns._ID,
                BookDBScheme.COLUMN_NAME,
                BookDBScheme.COLUMN_AUTHOR,
                BookDBScheme.COLUMN_PUBLICATION_YEAR,
                BookDBScheme.COLUMN_EDITORIAL,
                BookDBScheme.COLUMN_PAGES
            ),*/
            // columns null, so i can obtain all columns
            null,
            null, null, null, null, null
        )
        val books = mutableListOf<Book>()
        with(cursor){
            while(moveToNext()){
                books.add(
                    Book(
                        title = getString(getColumnIndexOrThrow(BookDBScheme.COLUMN_NAME)),
                        author = getString(getColumnIndexOrThrow(BookDBScheme.COLUMN_AUTHOR)),
                        publicationYear = getInt(getColumnIndexOrThrow(BookDBScheme.COLUMN_PUBLICATION_YEAR)),
                        editorial = getString(getColumnIndexOrThrow(BookDBScheme.COLUMN_EDITORIAL)),
                        pages = getInt(getColumnIndexOrThrow(BookDBScheme.COLUMN_PAGES))
                    ))
            }
        }
        cursor.close()
        return books.toList()
    }

    fun saveBook(book: Book) {
        val values = ContentValues().apply {
            put(BookDBScheme.COLUMN_NAME, book.title)
            put(BookDBScheme.COLUMN_AUTHOR, book.author)
            put(BookDBScheme.COLUMN_PUBLICATION_YEAR, book.publicationYear)
            put(BookDBScheme.COLUMN_EDITORIAL, book.editorial)
            put(BookDBScheme.COLUMN_PAGES, book.pages)
        }


        writableDB.insert(BookDBScheme.TABLE_NAME, null, values)
    }
}