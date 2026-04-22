package com.example.wordtrainer.domain.repository.use_case.collection

class CollectionUseCases (
    val getCollections: GetCollectionsUseCase,
    val deleteCollection: DeleteCollectionUseCase,
    val addCollection: AddCollection,
    val getCollection: GetCollection
)