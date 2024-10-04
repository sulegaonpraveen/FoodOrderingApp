package com.example.foodorderingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodorderingapp.ui.theme.FoodOrderingAppTheme
import kotlinx.coroutines.delay
import androidx.room.Room

class SplashScreen : ComponentActivity() {

    companion object{
        lateinit var productcartDatabase: ProductcartDatabase
    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        productcartDatabase = Room.databaseBuilder(applicationContext,ProductcartDatabase::class.java, ProductcartDatabase.NAME).build()
        enableEdgeToEdge()
        setContent {
            FoodOrderingAppTheme {
                Navigation()
            }
        }
    }
}


@Composable
fun SplashScreenComponent(navController : NavController) {

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(Routes.mainscreen)
    }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.splashscreen),
            contentDescription = "splash screen image",
             alignment = Alignment.Center,
            modifier = Modifier.padding(0.dp,100.dp,0.dp,0.dp))

        Text(text = "Waves Of Food",
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))

        Text(text = "Deliver Favorite Food",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))

        Text(text = "Design By \n Praveen Sulegaon",
            color = colorResource(id = R.color.GradientGreen),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp,300.dp,0.dp,0.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    val navController = rememberNavController()
    FoodOrderingAppTheme {
        SplashScreenComponent(navController)
    }
}