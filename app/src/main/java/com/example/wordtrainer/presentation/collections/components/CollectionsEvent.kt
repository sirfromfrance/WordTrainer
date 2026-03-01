package com.example.wordtrainer.presentation.collections.components

import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.util.CollectionOrder

sealed class CollectionsEvent {
    data class Order(val collectionOrder: CollectionOrder): CollectionsEvent()

    data class DeleteCollection(val wordCollection: WordCollection): CollectionsEvent()

    object RestoreCollection: CollectionsEvent()
    object ToggleOrderSection: CollectionsEvent()
}