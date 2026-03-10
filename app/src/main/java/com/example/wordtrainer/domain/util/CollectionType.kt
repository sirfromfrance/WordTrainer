package com.example.wordtrainer.domain.util

sealed class CollectionOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): CollectionOrder(orderType)

    class Date(orderType: OrderType): CollectionOrder(orderType)

    class Color(orderType: OrderType): CollectionOrder(orderType)

    fun copy(orderType: OrderType): CollectionOrder{
        return when(this){
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Color -> Color(orderType)
        }
    }
}