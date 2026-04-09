package com.example.wordtrainer.data.repository
import com.example.wordtrainer.data.data_source.CardDao
import com.example.wordtrainer.domain.repository.CardRepository

class CardRepositoryImpl (
    private val dao: CardDao
): CardRepository {

}
