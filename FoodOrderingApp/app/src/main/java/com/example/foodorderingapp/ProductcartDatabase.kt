package com.example.foodorderingapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductCart::class], version = 1)
 abstract class ProductcartDatabase : RoomDatabase() {

  companion object{
    const val NAME = "ProductCart_Db"

  }
  abstract fun GetProductKartDAO() : ProductKartDAO
}