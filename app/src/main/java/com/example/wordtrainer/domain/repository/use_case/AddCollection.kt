package com.example.wordtrainer.domain.repository.use_case

import com.example.wordtrainer.InvalidCollectionException
import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.repository.CollectionRepository
import kotlin.jvm.Throws

class AddCollection (private val repository: CollectionRepository) {
    @Throws(InvalidCollectionException::class)
    suspend operator fun invoke(wordCollection: WordCollection){
        if(wordCollection.name.isBlank()) {
            throw InvalidCollectionException("The title of the collection can't be empty")
        }

        repository.insertCollection(wordCollection)
    }
}