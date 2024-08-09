package com.example.tenant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.model.WokerModel
import com.example.tenant.databinding.WorkerItemBinding

class WorkerItemAdapter(private val context: Context, private val workerList: List<WokerModel>) :
    RecyclerView.Adapter<WorkerItemAdapter.WorkerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerViewHolder {
        val binding = WorkerItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return WorkerViewHolder(binding)
    }

    override fun getItemCount() = workerList.size

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {
        val workeritem = workerList[position]
        holder.bind(workeritem)
    }

    class WorkerViewHolder(val binding: WorkerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(workerItem: WokerModel) {
            binding.imgUserProfile.setImageResource(workerItem.userimage)
            binding.tvUserName.text = workerItem.userName
            binding.tvBranch.text = "Branch: ${workerItem.branch}"
            binding.tvTrader.text = workerItem.trads
            binding.tvContactNum.text = workerItem.contact.toString()

        }
    }

}