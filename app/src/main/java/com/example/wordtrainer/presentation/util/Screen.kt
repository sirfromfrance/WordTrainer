package com.example.wordtrainer.presentation.util

sealed class Screen(val route: String) {
    object CollectionsScreen: Screen("collection_screen")
    object AddEditCollectionScreen: Screen("add_edit_collection_screen")
}