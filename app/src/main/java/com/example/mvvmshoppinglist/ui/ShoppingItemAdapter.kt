package com.example.mvvmshoppinglist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.db.ShopItem

class ShoppingItemAdapter(
    val items : List<ShopItem>,
    val viewModel : ShopViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.CustomView>() {

    class CustomView(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return CustomView(view)
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        items.size
    }
}