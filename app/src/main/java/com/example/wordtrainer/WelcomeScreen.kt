package com.example.wordtrainer

import android.provider.SyncStateContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {



    val logoBox = Modifier
        .background(Color.Green)
        .padding(4.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            ) {
            Image(
                painter = painterResource(id = R.drawable.kolibri),
                contentDescription = "Logo image",
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Fit,
                )

            Text(text = "Word Trainer", fontSize = 25.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, modifier = logoBox)

        }

        Text(text = "Created for language learning", textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            navController.navigate("Overlook_Screen")
        } ) {
                Text(text = "Start learning")
        }

    }
}