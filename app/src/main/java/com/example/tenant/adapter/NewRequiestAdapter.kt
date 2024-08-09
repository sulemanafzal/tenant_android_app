package com.example.tenant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.databinding.ItemRecentBinding
import com.example.tenant.model.RecentModel

class NewRequiestAdapter(private val context: Context,
                         private val list: List<RecentModel>,
    // private val onMenuClickListener: (RecentModel) -> Unit
) : RecyclerView.Adapter<NewRequiestAdapter.NewRViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewRViewHolder {
        val binding = ItemRecentBinding.inflate(LayoutInflater.from(context), parent, false)
        return NewRViewHolder(context, binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewRViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    class NewRViewHolder(
        private val context: Context,
        val binding: ItemRecentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecentModel) {
            binding.title.text = item.title
            binding.postDate.text = item.postDate
            binding.postTime.text = item.postTime
            binding.complaintId.text = "Complaint ID: ${item.id}"
            binding.status.text = "Status:"
            binding.statusIndicator.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    item.statusIndicatorColor
                )
            )
            binding.stat.text = item.status
            binding.postDate.text = "Posted: ${item.postDate}"
            binding.menuIcon.setOnClickListener {
                // onMenuClickListener(item)
            }
        }
    }


}