package com.example.foodorderingapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class ProductCart(
    @PrimaryKey
    val productId : Int,
    val Image : Int,
    val description : String,
    val Amount : String
)
