package com.example.wordtrainer.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wordtrainer.WordCollection


@Database(
    entities = [WordCollection::class],
    version = 1
)

abstract class CollectionDB:RoomDatabase() {
    abstract val collectionDao: CollectionDao

    companion object{
        const val DATABASE_NAME = "collections_db"
    }
}