package com.example.wordtrainer.domain.util
import com.example.wordtrainer.domain.repository.use_case.collection.AddCollection
import com.example.wordtrainer.domain.repository.use_case.collection.DeleteCollectionUseCase
import com.example.wordtrainer.domain.repository.use_case.collection.GetCollection

data class CollectionsUseCases(
    val getCollection: GetCollection,
    val deleteCollection: DeleteCollectionUseCase,
    val addCollection: AddCollection
)
