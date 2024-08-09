package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tenant.model.CategoriesModel
import com.example.tenant.R
import com.example.tenant.model.WokerModel
import com.example.tenant.adapter.CategoriesAdapter
import com.example.tenant.adapter.WorkerItemAdapter
import com.example.tenant.databinding.FragmentWorkerBinding

class WorkerFragment : Fragment() {

    private lateinit var binding: FragmentWorkerBinding

    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var workerAdapter: WorkerItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkerBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = listOf<CategoriesModel>(
            CategoriesModel(
                R.drawable.ic_all,
                "All"
            ),
            CategoriesModel(
                R.drawable.ic_plumber,
                "plumber"
            ),
            CategoriesModel(
                R.drawable.ic_electrician,
                "Electrician"
            ),
            CategoriesModel(
                R.drawable.ic_carpenter,
                "Carpenter"
            ),
            CategoriesModel(
                R.drawable.ic_ac,
                "AC"
            ),
        )

        val workers = arrayListOf<WokerModel>(
            WokerModel(
                R.drawable.im, "Matthew John", "Gas, Plumbing, Carpenter",
                "Downtown", 123456331
            ),
            WokerModel(
                R.drawable.im, "Matthew John", "Gas, Plumbing, Carpenter",
                "Downtown", 123456331
            ),
            WokerModel(
                R.drawable.im, "Matthew John", " Gas, Plumbing, Carpenter",
                " Downtown", 123456331
            ),
            WokerModel(
                R.drawable.im, "Matthew John", " Gas, Plumbing, Carpenter",
                " Downtown", 123456331
            ),
        )
        workerAdapter = WorkerItemAdapter(requireContext(), workers)
        categoriesAdapter = CategoriesAdapter(requireContext(), categories)

        binding.rvCategories.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = categoriesAdapter
        }

        binding.rvWorker.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = workerAdapter
        }
    }
}
