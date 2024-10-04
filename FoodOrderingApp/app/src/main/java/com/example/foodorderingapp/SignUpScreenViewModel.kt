package com.example.foodorderingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpScreenViewModel  : ViewModel() {

    private val _userName = MutableLiveData<String>()
    val userName : LiveData<String> = _userName

    private val _password = MutableLiveData<String>()
    val password : LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword : LiveData<String> = _confirmPassword

    private val _signUpStatus = MutableLiveData<String>()
    val signUpStatus : LiveData<String> = _signUpStatus

    fun onUserNameUpdate(userName: String){
        _userName.value = userName
    }

    fun onPasswordUpdate(password: String){
        _password.value  = password
    }

    fun onPassworConfirmdUpdate(password: String){
        _confirmPassword.value  = password
    }

    fun onSignUpUpdate(status: String){
        _signUpStatus.value  = status
    }
}