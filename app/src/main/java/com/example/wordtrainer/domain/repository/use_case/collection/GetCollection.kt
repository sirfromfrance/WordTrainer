package com.example.wordtrainer.domain.repository.use_case.collection

import com.example.wordtrainer.data.data_source.WordCollection
import com.example.wordtrainer.domain.repository.CollectionRepository

class GetCollection (
    private val repository: CollectionRepository
){
    suspend operator fun invoke(id: Int): WordCollection?{
        return repository.getCollection(id)
    }
}