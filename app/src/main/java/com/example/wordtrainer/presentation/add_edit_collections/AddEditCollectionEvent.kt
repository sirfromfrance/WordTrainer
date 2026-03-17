package com.example.wordtrainer.presentation.add_edit_collections

import androidx.compose.ui.focus.FocusState

sealed class AddEditCollectionEvent {
    data class EnteredTitle(val value: String): AddEditCollectionEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditCollectionEvent()

    //event for changing color
    data class ChangeColor(val color: Int): AddEditCollectionEvent()
    object SaveCollection: AddEditCollectionEvent()
}