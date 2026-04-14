package com.example.wordtrainer.data.repository
import com.example.wordtrainer.data.data_source.Card
import com.example.wordtrainer.data.data_source.CardDao
import com.example.wordtrainer.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class CardRepositoryImpl (
    private val dao: CardDao
): CardRepository {
    override fun getCards(): Flow<List<Card>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCard(id: Int): Card? {
        return dao.getCardById(id)
    }

    override suspend fun insertCard(card: Card) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCard(card: Card) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCard(card: Card) {
        return dao.deleteCard(card)
    }

}
