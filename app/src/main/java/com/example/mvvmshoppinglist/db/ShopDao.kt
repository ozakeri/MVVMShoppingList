package com.example.mvvmshoppinglist.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(shopItem: ShopItem)

    @Delete
    suspend fun detele(shopItem: ShopItem)

    @Query("SELECT * FROM shop_items")
    fun getAllItems(): LiveData<List<ShopItem>>
}