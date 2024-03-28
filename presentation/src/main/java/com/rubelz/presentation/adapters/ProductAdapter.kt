package com.rubelz.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rubelz.data.remote.models.ProductDto
import com.rubelz.domain.entities.Product
import com.rubelz.presentation.databinding.ItemProductBinding

class ProductAdapter(private var productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    fun addProducts(productList: List<Product>) {
        this.productList = productList
        notifyDataSetChanged() // Да, нужно использовать DiffUtil
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val bind = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind.productName.text = product.strMeal
        holder.bind.productDescription.text =
            product.getIngredients().filterNotNull().filter { it.isNotEmpty() }
                .joinToString(",") { it }
        Glide.with(holder.itemView)
            .load(product.strMealThumb)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(holder.bind.productImage)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(val bind: ItemProductBinding) :
        RecyclerView.ViewHolder(bind.root) {
    }
}