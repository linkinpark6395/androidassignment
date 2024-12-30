package com.example.androidassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignment.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cart = CartHolder.cart

        binding.rvCart.layoutManager = LinearLayoutManager(this)
        binding.rvCart.adapter = CartAdapter(cart.getCartItems())
    }
}
