package com.example.androidassignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val productList = listOf(
        Product("Product 1", 100.0),
        Product("Product 2", 200.0),
        Product("Product 3", 150.0),
        Product("Product 4", 250.0),
        Product("Product 5", 300.0)
    )
    private val cart = CartHolder.cart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.adapter = ProductAdapter(productList, cart, this::updateCartCount)

        binding.ivCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
        updateCartCount()
    }

    private fun updateCartCount() {
        binding.tvCartCount.text = cart.totalQuantity().toString()
    }
}
