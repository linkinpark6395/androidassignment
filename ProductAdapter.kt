package com.example.androidassignment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignment.databinding.ItemProductBinding

class ProductAdapter(
    private val products: List<Product>,
    private val cart: Cart,
    private val onCartUpdate: () -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.binding.root.context, ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            holder.binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = products.size

    inner class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.tvProductName.text = product.name
            binding.tvProductPrice.text = "$${product.price}"

            binding.btnAddToCart.setOnClickListener {
                cart.addItem(product)
                binding.btnAddToCart.visibility = View.GONE
                binding.layoutQuantity.visibility = View.VISIBLE
                binding.tvQuantity.text = cart.getQuantity(product).toString()
                onCartUpdate()
            }

            binding.btnPlus.setOnClickListener {
                cart.addItem(product)
                binding.tvQuantity.text = cart.getQuantity(product).toString()
                onCartUpdate()
            }

            binding.btnMinus.setOnClickListener {
                cart.removeItem(product)
                val quantity = cart.getQuantity(product)
                binding.tvQuantity.text = quantity.toString()
                if (quantity == 0) {
                    binding.layoutQuantity.visibility = View.GONE
                    binding.btnAddToCart.visibility = View.VISIBLE
                }
                onCartUpdate()
            }
        }
    }
}
