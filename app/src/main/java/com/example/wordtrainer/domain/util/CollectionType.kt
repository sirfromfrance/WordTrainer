package com.example.wordtrainer.domain.util

sealed class CollectionOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): CollectionOrder(orderType)

    class Date(orderType: OrderType): CollectionOrder(orderType)

    class Color(orderType: OrderType): CollectionOrder(orderType)
}