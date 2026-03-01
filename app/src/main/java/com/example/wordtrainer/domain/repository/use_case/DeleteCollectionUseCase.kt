package com.example.wordtrainer.domain.repository.use_case

import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.repository.CollectionRepository

class DeleteCollectionUseCase(
    private val repository: CollectionRepository
){
    suspend operator fun invoke(collection: WordCollection){
        repository.deleteCollection(collection)
    }
}