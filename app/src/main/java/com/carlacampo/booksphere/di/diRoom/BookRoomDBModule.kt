package com.carlacampo.booksphere.di.diRoom

import android.content.Context
import androidx.room.Room
import com.carlacampo.booksphere.bbdd.roomBookdb.BookRoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object BookRoomDBModule {
    const val DATABASE_NAME = "BookRoomDB.db"

    @Provides
    fun providesBookRoomDBModule(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        BookRoomDB::class.java, DATABASE_NAME
    ).build()

    @Provides
    fun providesBookDao(bookRoomDB: BookRoomDB) = bookRoomDB.bookRoomDao()
}