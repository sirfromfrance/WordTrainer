package com.example.wordtrainer

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.wordtrainer.ui.theme.Blue200
import com.example.wordtrainer.ui.theme.Pink80
import com.example.wordtrainer.ui.theme.Purple40
import com.example.wordtrainer.ui.theme.Green300
import com.example.wordtrainer.ui.theme.PurpleGrey40

@Entity
data class WordCollection(
    @PrimaryKey val id: Int? = null,
    val name: String,
    val language: String,
    val color: Int,
    val createdAt: Long
){
    companion object{
        val collectionColors = listOf(Purple40, Pink80,Blue200, Green300, PurpleGrey40)
    }
}

class InvalidCollectionException(message: String): Exception(message)