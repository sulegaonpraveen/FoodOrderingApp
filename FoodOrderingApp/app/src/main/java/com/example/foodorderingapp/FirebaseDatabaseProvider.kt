package com.example.foodorderingapp

import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseDatabaseProvider {

    var db : FirebaseDatabase = FirebaseDatabase.getInstance()

    var reference : DatabaseReference = db.getReference("Users")

    fun InsertData(userName : String, password: String)
    {
       var user = Users(userName,password)
        reference.child(userName).setValue(user)

    }

    fun PushproductsToCart(productList: ProductList)
    {
        reference = db.getReference("Products")
        reference.child(productList.productId.toString()).setValue(productList)

    }

    fun GetproductsOfCart()
    {
        reference = db.getReference("Products")

        var productList : MutableList<ProductList> = arrayListOf();
        reference.get().addOnSuccessListener {
            if (it.exists()) {
                for(product in it.children){
                   var data = product.value as MutableMap<Any, Any>
                    var dataProduct = ProductList(data["productId"].toString().toInt(), data["image"].toString().toInt(), data["description"].toString(), data["amount"].toString())
                    productList.add(dataProduct)
                }
            }
        }
    }

    fun ValidateUser(navController: NavController, viewModel: LoginScreenViewModel,userName : String,password : String) : Boolean {

        var validUser : Boolean = false

        reference.child(userName).get().addOnSuccessListener {
            if (it.exists()) {
                if(password == it.child("password").value) {
                    viewModel.onStatusUpdate("Login Successful")
                    navController.navigate(Routes.locationScreen)
                }
                else
                    viewModel.onStatusUpdate("Login Failed")
            }
            else{
                viewModel.onStatusUpdate("Login Failed")
            }
        }.addOnFailureListener{
            validUser = false
        }

        return validUser
    }
}