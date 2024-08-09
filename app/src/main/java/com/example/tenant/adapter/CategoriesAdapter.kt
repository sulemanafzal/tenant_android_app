package com.example.tenant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.model.CategoriesModel
import com.example.tenant.databinding.WorkerCategoryBinding

class CategoriesAdapter(
    private val context: Context,
    private val categories: List<CategoriesModel>
) : RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(val binding: WorkerCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoriesModel) {
            binding.tvCategory.text = category.categoryName
            binding.imgCategory.setImageResource(category.categoryImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            WorkerCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount() = categories.size
}
