package com.example.mvvmshoppinglist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.db.ShopItem
import com.example.mvvmshoppinglist.repository.ShoppingRepository
import kotlinx.coroutines.coroutineScope

class ShopViewModel(private val repository: ShoppingRepository) : ViewModel() {

    suspend fun insert(item: ShopItem) {
        coroutineScope {
            repository.insert(item)
        }
    }

    suspend fun delete(item: ShopItem) {
        coroutineScope {
            repository.delete(item)
        }
    }

    fun getAll():LiveData<List<ShopItem>> = repository.getAll()

}