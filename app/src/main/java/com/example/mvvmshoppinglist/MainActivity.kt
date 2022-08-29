package com.example.mvvmshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglist.db.ShopItem
import com.example.mvvmshoppinglist.ui.ShopViewModel
import com.example.mvvmshoppinglist.ui.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MainActivity : AppCompatActivity() , KodeinAware{

    private lateinit var viewModel: ShopViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(ShopViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(),viewModel)

        val lm = LinearLayoutManager(this)
        rvShoppingItems.layoutManager = lm

        viewModel.getAll().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener(){
            AddShoppingItemDialog(this,object : ItemListener{
                override fun buttonClick(item: ShopItem) {
                    viewModel.insert(item)

                }

            })
        }
    }

    override val kodein: Kodein
        get() = TODO("Not yet implemented")
}