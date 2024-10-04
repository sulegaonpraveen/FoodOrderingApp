package com.example.foodorderingapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodorderingapp.ui.theme.FoodOrderingAppTheme

class ShoppingCartScreen : ComponentActivity() {



}

@Composable
fun ShoppingCartScreenComponent(navController : NavController,modifier: Modifier = Modifier, viewModel:  ShoppingCartScreenViewModel = ShoppingCartScreenViewModel()) {

    val menuItems by viewModel.productKartList.observeAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(0.dp, 50.dp, 0.dp, 0.dp)
            .background(Color(0xFFF6F9FA))
    ){
        Text(text = "Cart", color = colorResource(id = R.color.black), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

        Column {
            menuItems?.forEachIndexed { index, productList ->

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(20.dp)
                    .background(color = Color.White),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = productList.Image), contentDescription = productList.description, modifier = Modifier.padding(2.dp))
                    Text(text = productList.description)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartScreenPreview() {
    val navController = rememberNavController()
    FoodOrderingAppTheme {
        ShoppingCartScreenComponent(navController)
    }
}