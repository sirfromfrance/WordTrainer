package com.example.wordtrainer.presentation.collections.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wordtrainer.domain.util.CollectionOrder
import com.example.wordtrainer.domain.util.OrderType

@Composable

fun OrderSection(
    modifier: Modifier = Modifier,
    collectionOrder: CollectionOrder = CollectionOrder.Date(OrderType.Descending),
    onOrderChange: (CollectionOrder) -> Unit
){
    Column(
        modifier = modifier
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            DefaultRadioButton(
                text = "Title",
                selected = collectionOrder is CollectionOrder.Title,
                onSelect = {onOrderChange(CollectionOrder.Title(collectionOrder.orderType))}
            )
            Spacer(modifier = Modifier.width((8.dp)))
            DefaultRadioButton(
                text = "Date",
                selected = collectionOrder is CollectionOrder.Date,
                onSelect = {onOrderChange(CollectionOrder.Date(collectionOrder.orderType))}
            )
            Spacer(modifier = Modifier.width((8.dp)))
            DefaultRadioButton(
                text = "Color",
                selected = collectionOrder is CollectionOrder.Color,
                onSelect = {onOrderChange(CollectionOrder.Color(collectionOrder.orderType))}
            )
            Spacer(modifier = Modifier.width((8.dp)))
        }
        Spacer(modifier = Modifier.height((16.dp)))
        Row(modifier = Modifier.fillMaxWidth()){
            DefaultRadioButton(
                text = "Ascending",
                selected = collectionOrder.orderType is OrderType.Ascending ,
                onSelect = {
                    onOrderChange(collectionOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = collectionOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(collectionOrder.copy((OrderType.Descending)))
                }
            )
        }
    }

}