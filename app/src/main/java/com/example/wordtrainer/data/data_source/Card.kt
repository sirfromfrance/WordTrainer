package com.example.wordtrainer.data.data_source

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = WordCollection::class,
            parentColumns = ["id"],
            childColumns = ["collectionId"],
            onDelete = ForeignKey.Companion.CASCADE
        )
    ]
)

data class Card(
    @PrimaryKey(autoGenerate = true) val wordId: Int? =null,
    val collectionId: Int,
    val word: String,
    val description: String,
    val imageURL: String?,

)