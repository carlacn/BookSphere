package com.carlacampo.booksphere.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BooksDataStore

/*
this notation works in case we've got two context, so hilt can distinguish the data type
One notation for each
 */
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    //create datastore
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "books")

    //inject datastore through hilt
    @Provides
    @BooksDataStore
    fun provideBooksDataStore(@ApplicationContext context: Context) = context.dataStore

}


