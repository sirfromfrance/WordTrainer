package com.example.wordtrainer.domain.util
import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.repository.use_case.AddCollection
import com.example.wordtrainer.domain.repository.use_case.DeleteCollectionUseCase
import com.example.wordtrainer.domain.repository.use_case.GetCollectionUseCase

data class CollectionsUseCases(
    val getCollection: GetCollectionUseCase,
    val deleteCollection: DeleteCollectionUseCase,
    val addCollection: AddCollection
)
