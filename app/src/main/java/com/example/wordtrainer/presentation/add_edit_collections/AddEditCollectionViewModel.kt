package com.example.wordtrainer.presentation.add_edit_collections

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.wordtrainer.domain.repository.use_case.CollectionUseCases
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap
import jakarta.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.toArgb
import com.example.wordtrainer.WordCollection
import kotlinx.coroutines.flow.MutableSharedFlow
import com.example.wordtrainer.presentation.add_edit_collections.CollectionTextFieldState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

@HiltViewModel
class AddEditCollectionViewModel @Inject constructor(
    private val collectionUseCases: CollectionUseCases
): ViewModel() {

    private val _collectionTitle = mutableStateOf(CollectionTextFieldState(
        hint = "Enter title"
    ))
    val collectionTitle: State<CollectionTextFieldState> = _collectionTitle

    private val _collectionContent = mutableStateOf(CollectionTextFieldState(
        hint = "Enter word"
    ))
    val collectionContent: State<CollectionTextFieldState> = _collectionContent

    private val _collectionColor = mutableStateOf<Int>(WordCollection.collectionColors.random().toArgb())
    val collectionColor:State<Int> = _collectionColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UiEvent{
        data class ShowSnackbar(val message:String): UiEvent()
        object SaveCollection: UiEvent()

    }
}