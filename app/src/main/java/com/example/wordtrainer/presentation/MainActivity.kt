package com.example.wordtrainer.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wordtrainer.OverlookScreen
import com.example.wordtrainer.Routes
import com.example.wordtrainer.WelcomeScreen
import com.example.wordtrainer.presentation.util.Screen
import com.example.wordtrainer.ui.theme.WordTrainerTheme
import com.example.wordtrainer.presentation.add_edit_collections.AddEditCollectionScreen
import dagger.hilt.android.AndroidEntryPoint


sealed class Destination(val route: String){
    object Collection: Destination("collection")
    object Word: Destination("word")

}
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WordTrainerTheme{
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navCollection = rememberNavController()
                    NavHost(navController = navCollection, startDestination = Screen.CollectionsScreen.route){
                        composable(route = Screen.CollectionsScreen.route){
                            CollectionsScreen(navCollection = navCollection)
                        }
                        composable(
                            route = Screen.AddEditCollectionScreen.route +
                                    "?collectionId={collectionId}&collectionColor={collectionColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "collectionId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(
                                    name = "collectionColor"
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ){
                            val color = it.arguments?.getInt("collectionColor") ?: -1
                            AddEditCollectionScreen(
                                navCollection = navCollection,
                                collectionColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}

