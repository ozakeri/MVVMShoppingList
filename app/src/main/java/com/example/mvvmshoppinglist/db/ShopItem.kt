package com.example.mvvmshoppinglist.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop_items")
data class ShopItem(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "amount")
    var amount: Int
) {

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
}