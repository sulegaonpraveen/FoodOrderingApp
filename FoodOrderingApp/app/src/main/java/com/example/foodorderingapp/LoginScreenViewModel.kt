package com.example.foodorderingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginScreenViewModel : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName : LiveData<String> = _userName

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _loginStatus = MutableLiveData<String>()
    val loginStatus : LiveData<String> = _loginStatus

    fun onUserNameUpdate(userName: String){
        _userName.value = userName
    }

    fun onPasswordUpdate(password: String){
        _password.value  = password
    }

    fun onStatusUpdate(status: String){
        _loginStatus.value  = status
    }
}