package com.example.wordtrainer.presentation.add_edit_collections

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.wordtrainer.domain.repository.use_case.collection.CollectionUseCases
import jakarta.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.wordtrainer.data.data_source.InvalidCollectionException
import com.example.wordtrainer.data.data_source.WordCollection
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
 class AddEditCollectionViewModel @Inject constructor(
    private val collectionUseCases: CollectionUseCases,
     savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _collectionTitle = mutableStateOf(CollectionTextFieldState(
        hint = "Enter title..."
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

    private var currentCollectionId: Int? = null

    init{
        savedStateHandle.get<Int>("collectionId")?.let {collectionId ->
            if(collectionId != -1){
                viewModelScope.launch{
                    collectionUseCases.getCollection(collectionId)?.also{
                        currentCollectionId = it.id
                        _collectionTitle.value = collectionTitle.value.copy(
                            title = it.name,
                            isHintVisible = false
                        )
                        _collectionColor.value = it.color

                    }
                }
            }
        }
    }


    fun onEvent(event: AddEditCollectionEvent){
        when(event){
           is AddEditCollectionEvent.EnteredTitle -> {
               _collectionTitle.value = collectionTitle.value.copy(
                   title = event.value
               )
           }
            is AddEditCollectionEvent.ChangeTitleFocus ->{
                _collectionTitle.value = collectionTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                    collectionTitle.value.title.isBlank()

                )
            }
            is AddEditCollectionEvent.ChangeColor ->{
                _collectionColor.value = event.color
            }
            is AddEditCollectionEvent.SaveCollection ->{
                viewModelScope.launch{
                    try{
                        collectionUseCases.addCollection(
                            WordCollection(
                                name = collectionTitle.value.title,
                                createdAt = System.currentTimeMillis(),
                                color = collectionColor.value,
                                id = currentCollectionId
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveCollection)

                    }catch(e: InvalidCollectionException){
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Couldn't save collection"
                            )
                        )

                    }
                }
            }
        }
    }

    sealed class UiEvent{
        data class ShowSnackbar(val message:String): UiEvent()
        object SaveCollection: UiEvent()

    }
}