package com.example.wordtrainer.presentation.add_edit_collections

import ads_mobile_sdk.h5
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.example.wordtrainer.WordCollection
import com.example.wordtrainer.presentation.add_edit_collections.components.TransparentHintTextField
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


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

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event){
                is AddEditCollectionViewModel.UiEvent.ShowSnackbar ->{
                    snackbarHostState.showSnackbar(
                        message = event.message
                    )

                }
                is AddEditCollectionViewModel.UiEvent.SaveCollection ->{
                    navCollection.navigateUp()

                }
            }
        }
    }

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
            modifier = Modifier
                .fillMaxSize()
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
            ){
                WordCollection.collectionColors.forEach{ color ->
                    val colorInt = color.toArgb()
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .shadow(15.dp, CircleShape)
                            .clip(CircleShape)
                            .background(color)
                            .border(
                                width = 3.dp,
                                color = if(viewModel.collectionColor.value == colorInt){
                                    Color.Black
                                }
                                else Color.Transparent,
                                shape = CircleShape
                            )
                            .clickable{
                                scope.launch {
                                    collectionBackgroundAnimatable.animateTo(
                                        targetValue = Color(colorInt),
                                        animationSpec = tween(
                                            durationMillis = 500

                                        )
                                    )
                                }
                                viewModel.onEvent(AddEditCollectionEvent.ChangeColor(colorInt))
                            }
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            TransparentHintTextField(
                text = titleState.title,
                hint = titleState.hint,
                onValueChange = {
                    viewModel.onEvent(AddEditCollectionEvent.EnteredTitle(it))
                } ,
                onFocusChange = {
                    viewModel.onEvent(AddEditCollectionEvent.ChangeTitleFocus(it))
                },
                isHintVisible =  titleState.isHintVisible,
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineLarge
            )


        }
    }
}