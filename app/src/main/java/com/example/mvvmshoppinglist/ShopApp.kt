package com.example.mvvmshoppinglist

import android.app.Application
import com.example.mvvmshoppinglist.db.ShopDatabase
import com.example.mvvmshoppinglist.repository.ShoppingRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ShopApp : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidCoreModule(this@ShopApp))
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from singleton { ShopDatabase(instance()) }
    }
}
