package com.example.mvvmshoppinglist.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.R
import com.example.mvvmshoppinglist.db.ShopItem
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items: List<ShopItem>,
    val viewModel: ShopViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.CustomView>() {

    inner class CustomView(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return CustomView(view)
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        val item = items.get(position)
        holder.itemView.tvName.setText(item.name)
        holder.itemView.tvAmount.setText(item.amount)

        holder.itemView.ivPlus.setOnClickListener {
            item.amount++
            viewModel.insert(item)
        }

        holder.itemView.ivDelete.setOnClickListener {
            if (item.amount > 0) {
                item.amount--
                viewModel.insert(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}