package com.example.androidassignment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(val name: String, val price: Double) : Parcelable

class Cart {
    private val items = mutableMapOf<Product, Int>()

    fun addItem(product: Product) {
        items[product] = items.getOrDefault(product, 0) + 1
    }

    fun removeItem(product: Product) {
        val quantity = items.getOrDefault(product, 0)
        if (quantity > 0) {
            items[product] = quantity - 1
            if (items[product] == 0) items.remove(product)
        }
    }

    fun getQuantity(product: Product): Int {
        return items.getOrDefault(product, 0)
    }

    fun totalQuantity(): Int {
        return items.values.sum()
    }

    fun getCartItems(): Map<Product, Int> {
        return items
    }
}
