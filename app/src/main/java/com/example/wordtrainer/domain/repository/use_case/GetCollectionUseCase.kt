package com.example.wordtrainer.domain.repository.use_case

import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.repository.CollectionRepository
import com.example.wordtrainer.domain.util.CollectionOrder
import com.example.wordtrainer.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCollectionUseCase (
    private val repository: CollectionRepository
){
    operator fun invoke(collectionOrder: CollectionOrder = CollectionOrder.Date(OrderType.Descending)
    ): Flow<List<WordCollection>> {
        return repository.getCollections().map{collections ->
            when(collectionOrder.orderType){
                is OrderType.Ascending ->{
                    when (collectionOrder){
                        is CollectionOrder.Date -> collections.sortedBy{it.createdAt}
                        is CollectionOrder.Title -> collections.sortedBy{it.name.lowercase()}
                        is CollectionOrder.Color -> collections.sortedBy { it.color }
                    }
                }
                is OrderType.Descending ->{
                    when (collectionOrder){
                        is CollectionOrder.Date -> collections.sortedByDescending{it.createdAt}
                        is CollectionOrder.Title -> collections.sortedByDescending{it.name.lowercase()}
                        is CollectionOrder.Color -> collections.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}