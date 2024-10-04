package com.example.foodorderingapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HistoryScreenViewModel : ViewModel() {

    var errorMessage : String by  mutableStateOf("")

    private val _movieListResponse = MutableLiveData<List<Movie>>()
    val movieListResponse : LiveData<List<Movie>> = _movieListResponse

    fun getMoviesList(){

            val apiService = ApiService.getInstance()

        viewModelScope.launch {
            try {
                _movieListResponse.value = apiService.GetMovies()

            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}