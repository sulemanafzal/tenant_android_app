package com.example.tenant.fragment

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.R
import com.example.tenant.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)

        val view = _binding!!.root


        _binding?.apply {
            btnSubmit.setOnClickListener {
                isValid(edittext = AppCompatEditText(requireContext()))
                /* if (isValid(etName) && isValid(etContactNumber) && isValid(etEmail)) {

                 }*/
                findNavController().navigate(R.id.action_registrationFragment_to_verificationFragment)
            }
            tvSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_registrationFragment_to_signInFragment)
            }
        }


        return view
    }

    private fun isValid(edittext: AppCompatEditText): Boolean {
        val text = edittext.text.toString()
        return when (edittext.id) {
            R.id.et_name -> {
                if (text.isNotEmpty())
                    true
                else {
                    edittext.error = getString(R.string.str_name_required)
                    false
                }
            }

            R.id.et_contact_number -> {
                if (text.isNotEmpty())
                    true
                else {
                    edittext.error = getString(R.string.str_contact_number_required)
                    false
                }
            }


            R.id.et_email -> {
                if (text.isNotEmpty()) {
                    if (!Patterns.EMAIL_ADDRESS.matcher(edittext.text.toString()).matches()) {
                        edittext.error = getString(R.string.str_provide_valid_email)
                        false
                    } else
                        true

                } else {
                    edittext.error = getString(R.string.str_provide_valid_email)
                    false
                }
            }

            else -> {
                false
            }
        }
    }
}