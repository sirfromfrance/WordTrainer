package com.example.wordtrainer.domain.repository

import com.example.wordtrainer.data.data_source.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {

    fun getCards(): Flow<List<Card>>

    suspend fun getCard(id: Int): Card?

    suspend fun insertCard(card: Card)
    
    suspend fun updateCard(card: Card)

    suspend fun deleteCard(card: Card)
}