package com.example.wordtrainer.domain.util
import com.example.wordtrainer.domain.repository.use_case.AddCollection
import com.example.wordtrainer.domain.repository.use_case.DeleteCollectionUseCase
import com.example.wordtrainer.domain.repository.use_case.GetCollection

data class CollectionsUseCases(
    val getCollection: GetCollection,
    val deleteCollection: DeleteCollectionUseCase,
    val addCollection: AddCollection
)
