package com.example.mvvmshoppinglist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.db.ShopItem
import com.example.mvvmshoppinglist.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ShopViewModel(private val repository: ShoppingRepository) : ViewModel() {

    fun insert(item: ShopItem) =
        GlobalScope.launch {
            repository.insert(item)
        }

    fun delete(item: ShopItem) {
        GlobalScope.launch {
            repository.delete(item)
        }
    }

    fun getAll(): LiveData<List<ShopItem>> = repository.getAll()

}