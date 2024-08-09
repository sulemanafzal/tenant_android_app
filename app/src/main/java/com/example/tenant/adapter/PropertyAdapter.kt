package com.example.tenant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.model.PropertyModel
import com.example.tenant.R
import com.example.tenant.databinding.ItemPropertyBinding

class PropertyAdapter(val context: Context, val list: List<PropertyModel>) :
    RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val binding = ItemPropertyBinding.inflate(LayoutInflater.from(context), parent, false)
        return PropertyViewHolder(context, binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val item_property = list[position]
        holder.bind(item_property)
    }

    class PropertyViewHolder(
        private val context: Context,
        val binding: ItemPropertyBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PropertyModel) {
            binding.tvInfo.text = item.info

binding.root.setOnClickListener {
    it.findNavController().navigate(R.id.action_propertyFragment_to_propertyDetailFragment)
}

        }
    }
}