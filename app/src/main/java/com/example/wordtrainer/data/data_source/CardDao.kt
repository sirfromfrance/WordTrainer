package com.example.wordtrainer.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface CardDao{
    @Query("SELECT * FROM Card WHERE wordId = :id")
    suspend fun getCardById(id:Int): Card?

    @Query("SELECT * FROM Card")
    fun getCards(): Flow<List<Card>>

    @Delete
    suspend fun deleteCard(card: Card)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCard(card:Card)

    @Query("UPDATE card set word = :word, description = :description, lastModified = :timestamp where wordId = :id")
    suspend fun updateCard(id:Int, word: String, description:String, timestamp: Long)

}
