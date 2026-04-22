package com.example.wordtrainer.domain.repository.use_case.collection

import com.example.wordtrainer.data.data_source.WordCollection
import com.example.wordtrainer.domain.repository.CollectionRepository

class DeleteCollectionUseCase(
    private val repository: CollectionRepository
){
    suspend operator fun invoke(collection: WordCollection){
        repository.deleteCollection(collection)
    }
}