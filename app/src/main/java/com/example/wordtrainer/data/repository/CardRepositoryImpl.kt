package com.example.wordtrainer.data.repository
import android.R.attr.id
import com.example.wordtrainer.data.data_source.Card
import com.example.wordtrainer.data.data_source.CardDao
import com.example.wordtrainer.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.descriptors.SerialDescriptor
import java.sql.Timestamp

class CardRepositoryImpl (
    private val dao: CardDao
): CardRepository {


    override suspend fun getCard(id: Int): Card? {
        return dao.getCardById(id)
    }

    override fun getCards(): Flow<List<Card>>{
        return dao.getCards()
    }

    override suspend fun insertCard(card: Card) {
        return dao.insertCard(card)
    }

    override suspend fun deleteCard(card: Card) {
        return dao.deleteCard(card)
    }

    override suspend fun updateCard(id: Int, word: String, description: String, lastModified:Long) {
        return dao.updateCard(id = id, word = word, description, lastModified)
    }

}
