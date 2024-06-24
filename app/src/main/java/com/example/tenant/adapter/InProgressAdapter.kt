package com.example.tenant.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tenant.databinding.InprogressItemBinding
import com.example.tenant.model.JobCard
import com.example.tenant.databinding.ItemJobBinding

class InProgressAdapter(private val joblist: ArrayList<JobCard>, val context: Context) :
    RecyclerView.Adapter<InProgressAdapter.JobViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val binding = InprogressItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return JobViewHolder(binding)
    }

    override fun getItemCount() = joblist.size

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {

        val jobitem = joblist[position]
        holder.bind(jobitem)

    }

    class JobViewHolder(val binding: InprogressItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(jobitem: JobCard) {
            binding.jobDate.text = jobitem.jobDateId.toString()
            binding.jobDescription.text = jobitem.jobDescriptionId.toString()
            binding.jobTitle.text = binding.jobTitle.toString()
            //  binding.imgApproval.setImageResource(jobitem.imgApprovalId)
            //binding.jobStatus.text = jobitem.jobStatusId.toString()
            binding.showDetailsButton.setOnClickListener {

            }
        }
    }

}