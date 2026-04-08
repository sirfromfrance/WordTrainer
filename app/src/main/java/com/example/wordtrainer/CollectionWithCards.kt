package com.example.wordtrainer

import androidx.room.Entity
import androidx.room.Embedded
import androidx.room.Relation
import com.example.wordtrainer.data.data_source.Card
import com.example.wordtrainer.data.data_source.WordCollection


data class CollectionWithCards(
    @Embedded
    val wordCollection: WordCollection,
    @Relation(
        parentColumn = "id",
        entityColumn = "collectionId"
    )
    val cards: List<Card>
)


