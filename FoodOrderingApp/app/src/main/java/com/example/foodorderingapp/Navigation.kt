package com.example.foodorderingapp

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink


@Composable
    fun Navigation() {

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.splashscreen) {
            composable(Routes.splashscreen)
            {
                SplashScreenComponent(navController)
            }
            composable(Routes.mainscreen){
                MainScreenComponent(navController)
            }
            composable(Routes.loginscreen){
                LoginScreenComponent(navController)
            }
            composable(Routes.signUpScreen){
                SignUpScreenComponent(navController)
            }
            composable(Routes.locationScreen){
                LocationScreenComponent(navController)
            }
            composable(Routes.homeScreen)
            {
                HomeScreenComponent(navController)
            }
            composable(Routes.shoppingCartScreen){
                ShoppingCartScreenComponent(navController)
            }
            composable(Routes.searchScreen){
                SearchScreenComponent(navController)
            }
            composable(Routes.historyScreen){
                HistoryScreenComponent(navController)
            }
            composable(Routes.profileScreen){
                ProfileScreenComponent(navController)
            }
            composable(Routes.foodMenuScreen){
                FoodMenuScreenComponent(navController)
            }
        }
    }
