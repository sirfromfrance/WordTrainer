package com.example.wordtrainer.presentation.add_edit_collections

sealed class AddEditCollectionEvent {
    data class EnteredTitle(val value: String): AddEditCollectionEvent()
}