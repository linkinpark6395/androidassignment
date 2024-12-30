package com.example.androidassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignment.databinding.ItemCartBinding

class CartAdapter(private val cartItems: Map<Product, Int>) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = cartItems.keys.toList()[position]
        val quantity = cartItems[product] ?: 0
        holder.bind(product, quantity)
    }

    override fun getItemCount(): Int = cartItems.size

    class CartViewHolder(private val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product, quantity: Int) {
            binding.tvCartProductName.text = product.name
            binding.tvCartProductQuantity.text = "Quantity: $quantity"
        }
    }
}
