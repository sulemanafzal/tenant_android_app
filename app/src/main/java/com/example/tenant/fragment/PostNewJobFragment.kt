package com.example.tenant.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenant.R
import com.example.tenant.adapter.UploadPhotoAdapter
import com.example.tenant.databinding.FragmentPostNewJobBinding

@Suppress("DEPRECATION")
class PostNewJobFragment : Fragment() {

    private lateinit var binding: FragmentPostNewJobBinding
    private val uploadedPhotos = mutableListOf<Uri>()
    private lateinit var adapter: UploadPhotoAdapter

    companion object {
        private const val REQUEST_CODE_PERMISSION = 100
        private const val REQUEST_CODE_PICK_IMAGE = 101
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostNewJobBinding.inflate(inflater, container, false)

        setupRecyclerView()
        setupButtonClickListener()

        binding.apply {
            btnSubmit.setOnClickListener {
                findNavController().navigate(R.id.action_postNewJobFragment_to_repairWorkFragment)
            }
        }

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvUploadedPhoto.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapter = UploadPhotoAdapter(uploadedPhotos, requireContext())
        binding.rvUploadedPhoto.adapter = adapter
    }

    private fun setupButtonClickListener() {
        binding.btnUploadPhoto.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    REQUEST_CODE_PERMISSION
                )
            } else {
                pickImageFromGallery()
            }
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
    }

    @Deprecated("Deprecated in Java")
    @SuppressLint("NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            data?.let {
                if (it.clipData != null) {
                    // Multiple images selected
                    val count = it.clipData!!.itemCount
                    for (i in 0 until count) {
                        val imageUri = it.clipData!!.getItemAt(i).uri
                        uploadedPhotos.add(imageUri)
                    }
                    adapter.notifyDataSetChanged()
                } else if (it.data != null) {
                    // Single image selected
                    val imageUri = it.data!!
                    uploadedPhotos.add(imageUri)
                    adapter.notifyItemInserted(uploadedPhotos.size - 1)
                }
            }
        }
    }
}
