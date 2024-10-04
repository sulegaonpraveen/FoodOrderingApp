package com.example.foodorderingapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductKartDAO {

    @Query("Select * from ProductCart")
    fun getAllData() : LiveData<List<ProductCart>>

    @Insert
    fun addData(productCart: ProductCart)

    @Query("delete from ProductCart where productId = :id")
    fun deleteFromKart(id : Int)

}