package com.example.foodorderingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    val productKartDAO = SplashScreen.productcartDatabase.GetProductKartDAO();

    fun addProductKart(productCart: ProductCart){

        viewModelScope.launch(Dispatchers.IO) {
            productKartDAO.addData(productCart)
        }
    }
}