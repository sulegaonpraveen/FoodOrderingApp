package com.example.foodorderingapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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

class LocationScreen : ComponentActivity() {
}

@Composable
fun LocationScreenComponent(navController : NavController) {

    val isDropDownExpanded = remember {
        mutableStateOf(false)
    }

    val itemPosition = remember {
        mutableStateOf(0)
    }

    val locations = listOf("Hyderabad", "Jaipur", "Delhi", "Bangalore", "Chennai")


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp, 0.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
         ) {

        Text(text = "Choose Your Location",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))



        Box(modifier = Modifier
            .fillMaxWidth()
            ) {
            Row(
                modifier = Modifier
                    .clickable {
                        isDropDownExpanded.value = true
                    }
            ) {
                Text(text = locations[itemPosition.value], textAlign = TextAlign.Center )
                Spacer(modifier = Modifier.padding(10.dp,0.dp,0.dp,0.dp))
                Image(
                    painter = painterResource(id = R.drawable.dropdowncircle),
                    contentDescription = "DropDown Icon"
                )
            }

            DropdownMenu(
                expanded = isDropDownExpanded.value,
                onDismissRequest = {
                    isDropDownExpanded.value = false
                }) {
                locations.forEachIndexed { index, username ->
                    DropdownMenuItem(text = {
                        Text(text = username)
                    },
                        onClick = {
                            isDropDownExpanded.value = false
                            itemPosition.value = index
                            navController.navigate(Routes.foodMenuScreen)
                        })
                }
            }
        }

        Text(text = "To provide you with the best dining experience, we need your permission to access your device's location. By enabling location services, we can offer personalized restaurant recommendations, accurate delivery estimates, and ensure a seamless food delivery experience.",
            modifier = Modifier.padding(0.dp,550.dp,0.dp,10.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun LocationScreenPreview() {
    val navController = rememberNavController()
    FoodOrderingAppTheme {
        LocationScreenComponent(navController)
    }
}

