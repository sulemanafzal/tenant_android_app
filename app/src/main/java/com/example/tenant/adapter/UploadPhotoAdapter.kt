package com.example.tenant.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tenant.databinding.ItemUploadPhotoBinding

class UploadPhotoAdapter(private val photo: List<Uri>, val context: Context) :
    RecyclerView.Adapter<UploadPhotoAdapter.UploadPhotoVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadPhotoVH {
        val binding = ItemUploadPhotoBinding.inflate(LayoutInflater.from(context), parent, false)
        return UploadPhotoVH(binding)
    }

    override fun getItemCount() = photo.size

    override fun onBindViewHolder(holder: UploadPhotoVH, position: Int) {
        holder.bind(photo[position])

    }

    class UploadPhotoVH(val binding: ItemUploadPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(uri: Uri) {
            Glide.with(itemView.context)
                .load(uri)
                .centerCrop()
                .into(binding.uplodedPhoto)
        }
    }

}