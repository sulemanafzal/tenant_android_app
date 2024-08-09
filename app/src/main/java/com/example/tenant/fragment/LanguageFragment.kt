package com.example.tenant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.example.tenant.AppPreference
import com.example.tenant.R
import com.example.tenant.activity.CompanyActivity
import com.example.tenant.activity.MainActivity
import com.example.tenant.databinding.FragmentLanguageBinding

class LanguageFragment : Fragment() {

    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!
    private lateinit var preference: AppPreference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLanguageBinding.inflate(inflater, container, false)
        preference = AppPreference.getInstance(requireContext())
        //back arrow animation
        val arrowAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.back_arrow_anim)

        //setupInitialLanguage()
        setupListeners()
        binding.iconArrowBack.startAnimation(arrowAnim)

        return binding.root
    }

    /*    private fun setupInitialLanguage() {
            val languageCode = preference.languageCode
            if (languageCode.equals("en", true)) {
                binding.btnEnglish.isSelected = true
                binding.btnArabic.isSelected = false
            } else {
                binding.btnEnglish.isSelected = false
                binding.btnArabic.isSelected = true
            }
        }*/

    private fun setupListeners() {

        binding.btnEnglish.setOnClickListener {
            updateLanguage("en")
        }

        binding.btnArabic.setOnClickListener {
            updateLanguage("ar")
        }
    }

    private fun updateLanguage(languageCode: String) {
        CompanyActivity.ISRTLLayout = !preference.languageCode.equals("en", false)
        //rotating back arrow icon in right to left layout
        rotateBackArrow()
        preference.setLanguageCode(languageCode)
        setLanguageSelection(languageCode)
        refreshUI()
    }

    private fun rotateBackArrow() {
        if (CompanyActivity.ISRTLLayout) {
            _binding?.iconArrowBack?.rotation = 180F
        } else {
            _binding?.iconArrowBack?.rotation = 0F
        }
    }

    private fun setLanguageSelection(languageCode: String) {
        if (languageCode == "en") {
            binding.btnEnglish.isSelected = true
            binding.btnArabic.isSelected = false
        } else {
            binding.btnEnglish.isSelected = false
            binding.btnArabic.isSelected = true
        }
    }

    private fun refreshUI() {
        // Logic to refresh the UI with the new language
        // This may include restarting the activity, fragment, or using some other mechanism to update the UI
        activity?.recreate() // Example: Restart the activity to apply the new language
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
