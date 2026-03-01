package com.example.wordtrainer.domain.repository

import com.example.wordtrainer.WordCollection
import kotlinx.coroutines.flow.Flow

interface CollectionRepository {

    fun getCollections(): Flow<List<WordCollection>>

    suspend fun getCollection(id: Int): WordCollection?

    suspend fun insertCollection(collection: WordCollection)

    suspend fun deleteCollection(collection: WordCollection)
}