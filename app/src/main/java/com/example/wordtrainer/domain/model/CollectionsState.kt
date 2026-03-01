package com.example.wordtrainer.domain.model

import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.util.CollectionOrder
import com.example.wordtrainer.domain.util.OrderType

data class CollectionsState(
    val collections: List<WordCollection> = emptyList(),
    val collectionsOrder: CollectionOrder = CollectionOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
    )
