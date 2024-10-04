package com.example.foodorderingapp

import android.media.Image

class ProductList(val productId : Int, val Image : Int, val description : String, val Amount : String )

fun productData() : List<ProductList> {

    return listOf(
        ProductList(1,R.drawable.fruitsalad, "Fruit Salad", "$7"),
        ProductList(2,R.drawable.pancake, "Pan Cake", "$15"),
        ProductList(3,R.drawable.vegetablesalad, "Vegetable Salad", "$10"),
        ProductList(4,R.drawable.pancake, "Chicken Manchuria", "$17"),
        ProductList(5,R.drawable.fruitsalad, "Veg Pulavo", "$25")
    )
}
