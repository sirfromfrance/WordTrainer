package com.example.wordtrainer.data.repository

import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.data.data_source.CollectionDao
import com.example.wordtrainer.domain.repository.CollectionRepository
import kotlinx.coroutines.flow.Flow

class CollectionRepositoryImpl (
    private val dao: CollectionDao
): CollectionRepository{
    override fun getCollections(): Flow<List<WordCollection>> {
        return dao.getCollections()
    }

    override suspend fun getCollection(id: Int): WordCollection? {
        return dao.getCollectionById(id)
    }

    override suspend fun insertCollection(collection: WordCollection) {
        return dao.insertCollection(collection)
    }

    override suspend fun deleteCollection(collection: WordCollection) {
        return dao.deleteCollection(collection)
    }

}