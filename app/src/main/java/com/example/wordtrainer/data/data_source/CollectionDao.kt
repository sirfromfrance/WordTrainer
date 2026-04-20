package com.example.wordtrainer.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.google.crypto.tink.shaded.protobuf.Timestamp
import kotlinx.coroutines.flow.Flow

@Dao
interface CollectionDao {
    @Query("SELECT * FROM wordcollection")
    fun getCollections(): Flow<List<WordCollection>>

    @Query("Select * From wordcollection WHERE id = :id")
    suspend fun getCollectionById(id: Int): WordCollection?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollection(collection: WordCollection)



    @Delete
    suspend fun deleteCollection(collection: WordCollection)
}
