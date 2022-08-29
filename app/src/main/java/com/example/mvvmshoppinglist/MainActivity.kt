package com.example.mvvmshoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmshoppinglist.ui.ShopViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MainActivity : AppCompatActivity() , KodeinAware{

    private lateinit var viewModel: ShopViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(ShopViewModel::class.java)
    }

    override val kodein: Kodein
        get() = TODO("Not yet implemented")
}