package com.example.mvvmshoppinglist.repository

import androidx.lifecycle.LiveData
import com.example.mvvmshoppinglist.db.ShopDatabase
import com.example.mvvmshoppinglist.db.ShopItem

class ShoppingRepository(private val db: ShopDatabase) {

    suspend fun insert(shopItem: ShopItem) = db.getShopDao().insert(shopItem)

    suspend fun delete(shopItem: ShopItem) = db.getShopDao().detele(shopItem)

    fun getAll(): LiveData<List<ShopItem>> = db.getShopDao().getAllItems()
}