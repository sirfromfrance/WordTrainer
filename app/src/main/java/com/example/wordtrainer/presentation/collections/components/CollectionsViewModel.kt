package com.example.wordtrainer.presentation.collections.components
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.domain.model.CollectionsState
import com.example.wordtrainer.domain.repository.use_case.CollectionUseCases
import com.example.wordtrainer.domain.util.CollectionOrder
import com.example.wordtrainer.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CollectionsViewModel @Inject constructor(
    private val CollectionUseCases: CollectionUseCases
): ViewModel(){

    private val _state = mutableStateOf(CollectionsState())
    val state: State<CollectionsState> = _state

    private var recentlyDeletedCollection : WordCollection? = null

    init{
        getCollections(CollectionOrder.Date(OrderType.Descending))
    }

    private var getCollectionJob: Job? = null

    fun onEvent(event: CollectionsEvent){
        when(event){
            is CollectionsEvent.Order ->{
                if(state.value.collectionsOrder::class == event.collectionOrder::class
                    && state.value.collectionsOrder.orderType ==event.collectionOrder.orderType
                    ) {
                    return
                }
                getCollections(event.collectionOrder )

            }
            is CollectionsEvent.DeleteCollection -> {

                viewModelScope.launch{
                    CollectionUseCases.deleteCollection(event.wordCollection)
                    recentlyDeletedCollection = event.wordCollection
                }
            }
            is CollectionsEvent.RestoreCollection -> {
                viewModelScope.launch{
                    CollectionUseCases.addCollection(recentlyDeletedCollection ?: return@launch)
                    recentlyDeletedCollection = null

                }

            }
            is CollectionsEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )

            }
        }
    }

    private fun getCollections(collectionOrder: CollectionOrder){
        getCollectionJob?.cancel()
       getCollectionJob =  CollectionUseCases.getCollection(collectionOrder).onEach { collections ->
            _state.value = state.value.copy(collections = collections,
                collectionsOrder = collectionOrder
            )
        }.launchIn(viewModelScope)
    }

}