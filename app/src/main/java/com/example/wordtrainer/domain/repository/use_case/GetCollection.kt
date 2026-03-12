package com.example.wordtrainer.domain.repository.use_case

import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.repository.CollectionRepository

class GetCollection (
    private val repository: CollectionRepository
){
    suspend operator fun invoke(id: Int): WordCollection?{
        return repository.getCollection(id)
    }
}