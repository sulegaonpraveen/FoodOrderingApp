package com.example.foodorderingapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay

class MainScreen : ComponentActivity() {


}

@Composable
fun MainScreenComponent(navController : NavController) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.mainscreen),
            contentDescription = "splash screen image",
            alignment = Alignment.Center,
            modifier = Modifier.padding(0.dp,100.dp,0.dp,0.dp))

        Text(text = "Enjoy Restaurant Quality Meals at Home",
            color = colorResource(id = R.color.GradientGreen),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))

        Button(colors = ButtonColors(containerColor = colorResource(id = R.color.GradientGreen),
            contentColor = colorResource(id = R.color.white),
            disabledContentColor = colorResource(id = R.color.GradientGreen),
            disabledContainerColor = colorResource(id = R.color.GradientGreen) ),
            onClick = { navController.navigate(Routes.loginscreen) },modifier = Modifier
            .padding(0.dp, 100.dp, 0.dp, 0.dp)) {
            Text(text = "Next",
                color = colorResource(id = R.color.white),
                fontSize = 20.sp)
        }

        Text(text = "Design By \n Praveen Sulegaon",
            color = colorResource(id = R.color.GradientGreen),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp,80.dp,0.dp,0.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    FoodOrderingAppTheme {
        MainScreenComponent(navController)
    }
}
