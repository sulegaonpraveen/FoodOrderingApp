package com.example.foodorderingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.foodorderingapp.FirebaseDatabaseProvider.db
import com.example.foodorderingapp.FirebaseDatabaseProvider.reference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingCartScreenViewModel : ViewModel() {

    val productKartDAO = SplashScreen.productcartDatabase.GetProductKartDAO();

    val productKartList : LiveData<List<ProductCart>> = productKartDAO.getAllData()

    fun DeleteproductKart(id : Int){

        viewModelScope.launch(Dispatchers.IO) {
            productKartDAO.deleteFromKart(id)
        }
    }
}