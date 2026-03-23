package com.example.wordtrainer.presentation.add_edit_collections

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.SnackbarHost


@Composable
fun AddEditCollectionScreen(
    navCollection: NavController,
    collectionColor: Int,
    viewModel: AddEditCollectionViewModel = hiltViewModel()
) {
    val titleState = viewModel.collectionTitle.value
    val contentState = viewModel.collectionContent.value

    val snackbarHostState  = remember {SnackbarHostState()}

    val collectionBackgroundAnimatable = remember {
        Animatable(
            Color(
                if(collectionColor != -1) collectionColor
                else viewModel.collectionColor.value
            )
        )
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    viewModel.onEvent(AddEditCollectionEvent.SaveCollection)
                },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(imageVector = Icons.Default.Done, contentDescription = "Save collection")
                }
        },
    ) {
        paddings ->
        Column(
            modifier = Modifier.fillMaxSize()
                .background(collectionBackgroundAnimatable.value)
                .padding(paddings)
                .padding(16.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddings)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){}
        }
    }
}