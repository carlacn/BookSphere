package com.carlacampo.booksphere.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.carlacampo.booksphere.bbdd.BooksDBHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object BookDBModule {
    const val DATABASE_NAME = "BookRoom.db"

    @Provides
    fun providesBookDBHelper(@ApplicationContext context: Context): SQLiteDatabase {
        return BooksDBHelper(context).writableDatabase
    }
}