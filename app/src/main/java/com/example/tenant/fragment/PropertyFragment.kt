package com.example.tenant.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tenant.model.PropertyModel
import com.example.tenant.R
import com.example.tenant.adapter.PropertyAdapter
import com.example.tenant.databinding.FragmentPropertyBinding

class PropertyFragment : Fragment() {

    private var _binding: FragmentPropertyBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPropertyBinding.inflate(layoutInflater, container, false)
        val view = _binding?.root


        _binding?.apply {
            rvProperty.layoutManager = LinearLayoutManager(requireContext())
            val adapter = PropertyAdapter(requireContext(), getPropertyDetail(requireContext()))
            rvProperty.adapter = adapter
        }

        _binding?.apply {
            propertyBtnFab.setOnClickListener {

                findNavController().navigate(R.id.action_propertyFragment_to_addPropertyFragment)
            }
        }

        return view
    }

    private fun getPropertyDetail(context: Context): List<PropertyModel> {

        val propertyList = ArrayList<PropertyModel>()

        propertyList.add(
            PropertyModel(
                context.getString(R.string.str_building_50_district_abc_city_xyz)
            )
        )

        propertyList.add(
            PropertyModel(
                context.getString(R.string.str_building_50_district_abc_city_xyz)

            )
        )
        propertyList.add(
            PropertyModel(
                context.getString(R.string.str_building_50_district_abc_city_xyz)
            )
        )
        propertyList.add(
            PropertyModel(
                context.getString(R.string.str_building_50_district_abc_city_xyz)
            )
        )
        return propertyList
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}