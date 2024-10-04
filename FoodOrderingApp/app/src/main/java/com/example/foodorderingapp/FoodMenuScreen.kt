package com.example.foodorderingapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodorderingapp.ui.theme.FoodOrderingAppTheme

class FoodMenuScreen : ComponentActivity() {

}

@Composable
fun FoodMenuScreenComponent(navController : NavController) {

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    val navItemList = listOf(
        NavItem("Home",Icons.Default.Home,0),
        NavItem("cart",Icons.Default.ShoppingCart,0),
        NavItem("Search",Icons.Default.Search,0),
        NavItem("History",Icons.Default.Menu,0),
        NavItem("Profile",Icons.Default.Face,0)
    )
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(
            title = { Text(text = "Food Ordering App")},
            backgroundColor = Color(0xFFF6F9FA),
            modifier = Modifier.height(150.dp),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Rounded.Menu, contentDescription = "Menu Button")
                }
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Rounded.Notifications, contentDescription = "Notifications")
            }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Rounded.Search, contentDescription = "Notifications")
                }
            }
        )},
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index ,
                        onClick = { selectedIndex = index },
                        icon = { Icon(imageVector = navItem.Icon, contentDescription = navItem.label)},
                        label = { Text(text = navItem.label)})
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),navController, selectedIndex)
    }
}

@Composable
fun  ContentScreen(modifier: Modifier,navController : NavController, selectedIndex: Int){

   when(selectedIndex){
       0 -> HomeScreenComponent(navController = navController )
       1 -> ShoppingCartScreenComponent(navController = navController)
       2 -> SearchScreenComponent(navController = navController)
       3 -> HistoryScreenComponent(navController = navController)
       4 -> ProfileScreenComponent(navController = navController)
   }
}

@Preview(showBackground = true)
@Composable
fun FoodMenuScreenPreview() {
    val navController = rememberNavController()
    FoodOrderingAppTheme {
        FoodMenuScreenComponent(navController)
    }
}

