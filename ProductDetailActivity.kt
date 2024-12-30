package com.example.androidassignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidassignment.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var cart: Cart
    private lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cart = CartHolder.cart
        product = intent.getParcelableExtra("product")!!

        binding.tvProductDetailName.text = product.name
        binding.tvProductDetailPrice.text = "$${product.price}"
        binding.tvCartCountDetail.text = cart.totalQuantity().toString()

        binding.btnAddToCartDetail.setOnClickListener {
            cart.addItem(product)
            binding.tvCartCountDetail.text = cart.totalQuantity().toString()
        }

        binding.ivCartDetail.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}
