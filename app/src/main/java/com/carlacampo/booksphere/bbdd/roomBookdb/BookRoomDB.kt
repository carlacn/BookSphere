package com.carlacampo.booksphere.bbdd.roomBookdb

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1

@Database(entities = [BookEntity::class], version = DATABASE_VERSION)
abstract class BookRoomDB : RoomDatabase() {
    abstract fun bookRoomDao(): BookDao
}