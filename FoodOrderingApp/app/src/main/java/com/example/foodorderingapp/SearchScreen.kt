package com.example.foodorderingapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

class SearchScreen : ComponentActivity() {
}

@Composable
fun SearchScreenComponent(navController : NavController,modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxSize().background(Color(0xFFF6F9FA)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is  search Screen")
    }
}