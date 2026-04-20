package com.example.wordtrainer.data.data_source

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [WordCollection::class],
    version = 2,
//    autoMigrations = [
//        AutoMigration(from = 1, to = 2)
//    ]
)

abstract class CollectionDB:RoomDatabase() {
    abstract val collectionDao: CollectionDao

    companion object{
        const val DATABASE_NAME = "collections_db"
    }
}