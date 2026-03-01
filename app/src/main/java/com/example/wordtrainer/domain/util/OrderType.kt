package com.example.wordtrainer.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}