package com.example.wordtrainer.domain.repository.use_case.collection

import com.example.wordtrainer.data.data_source.InvalidCollectionException
import com.example.wordtrainer.data.data_source.WordCollection
import com.example.wordtrainer.domain.repository.CollectionRepository

class AddCollection (private val repository: CollectionRepository) {
    @Throws(InvalidCollectionException::class)
    suspend operator fun invoke(wordCollection: WordCollection){
        if(wordCollection.name.isBlank()) {
            throw InvalidCollectionException("The title of the collection can't be empty")
        }

        repository.insertCollection(wordCollection)
    }
}