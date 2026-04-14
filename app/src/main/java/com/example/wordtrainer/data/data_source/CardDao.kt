package com.example.wordtrainer.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query


@Dao
interface CardDao{
    @Query("SELECT * FROM Card WHERE wordId = :id")
    suspend fun getCardById(id:Int): Card?

    @Delete
    suspend fun deleteCard(card: Card)


}
