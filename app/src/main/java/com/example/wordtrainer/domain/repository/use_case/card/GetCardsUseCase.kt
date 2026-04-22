package com.example.wordtrainer.domain.repository.use_case.card

import com.example.wordtrainer.data.data_source.Card
import com.example.wordtrainer.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class GetCardsUseCase (
    private val repository: CardRepository
){
    operator fun invoke(collectionId: Int): Flow<List<Card>> {
        return repository.getCards()
    }
}