package com.example.wordtrainer.presentation.collections.components
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.model.CollectionsState
import com.example.wordtrainer.domain.repository.use_case.CollectionUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectionsViewModel @Inject constructor(
    private val CollectionUseCases: CollectionUseCases
): ViewModel(){

    private val _state = mutableStateOf(CollectionsState())
    val state: State<CollectionsState> = _state

    private var recentlyDeletedCollection : WordCollection? = null

    fun onEvent(event: CollectionsEvent){
        when(event){
            is CollectionsEvent.Order ->{

            }
            is CollectionsEvent.DeleteCollection -> {

                viewModelScope.launch{
                    CollectionUseCases.deleteCollection(event.wordCollection)
                    recentlyDeletedCollection = event.wordCollection
                }
            }
            is CollectionsEvent.RestoreCollection -> {
                viewModelScope.launch{

                }

            }
            is CollectionsEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )

            }
        }
    }

}