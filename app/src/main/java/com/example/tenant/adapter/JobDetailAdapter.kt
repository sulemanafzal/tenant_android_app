package com.example.tenant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.model.JobCard
import com.example.tenant.databinding.ItemJobBinding

class JobDetailAdapter(private val joblist: ArrayList<JobCard>, val context: Context) :
    RecyclerView.Adapter<JobDetailAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = ItemJobBinding.inflate(LayoutInflater.from(context), parent, false)
        return JobViewHolder(binding)
    }

    override fun getItemCount() = joblist.size

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val jobitem = joblist[position]
        holder.bind(jobitem)
    }
    class JobViewHolder(val binding: ItemJobBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(jobitem: JobCard) {
            binding.jobDate.text = jobitem.jobDateId
            binding.jobDescription.text = jobitem.jobDescriptionId
            binding.jobTitle.text = jobitem.jobTitleId
            binding.imgApproval.setImageResource(jobitem.imgApprovalId)
            binding.jobStatus.text = jobitem.jobStatusId
            binding.showDetailsButton.setOnClickListener {

            }
        }
    }

}