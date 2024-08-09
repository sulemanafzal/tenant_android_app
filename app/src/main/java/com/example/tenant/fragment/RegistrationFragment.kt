package com.example.tenant.fragment

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.R
import com.example.tenant.databinding.FragmentRegistrationBinding
import com.example.tenant.model.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    // Expected values
    private val expectedName = "test"
    private val expectedContact = "238479283"
    private val expectedEmail = "suleman@gmail.com"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.apply {
            btnSubmit.setOnClickListener {
                // Validate all input fields
                val isNameValid = isValid(etName)
                val isContactValid = isValid(etContactNumber)
                val isEmailValid = isValid(etEmail)

                // Check if all inputs match the expected values
                val isNameCorrect = etName.text.toString() == expectedName
                val isContactCorrect = etContactNumber.text.toString() == expectedContact
                val isEmailCorrect = etEmail.text.toString() == expectedEmail

                if (isNameValid && isContactValid && isEmailValid && isNameCorrect && isContactCorrect && isEmailCorrect) {
                    registerUser(
                        etName.text.toString(),
                        etContactNumber.text.toString(),
                        etEmail.text.toString(),
                        "company"
                    )
                } else {
                    // Show specific error messages
                    if (!isNameCorrect) {
                        etName.error = getString(R.string.str_name_required)
                    }
                    if (!isContactCorrect) {
                        etContactNumber.error = getString(R.string.str_contact_number_required)
                    }
                    if (!isEmailCorrect) {
                        etEmail.error = getString(R.string.str_provide_valid_email)
                    }
                }
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
                if (text.isNotEmpty()) true
                else {
                    edittext.error = getString(R.string.str_name_required)
                    false
                }
            }

            R.id.et_contact_number -> {
                if (text.isNotEmpty()) true
                else {
                    edittext.error = getString(R.string.str_contact_number_required)
                    false
                }
            }

            R.id.et_email -> {
                if (text.isNotEmpty()) {
                    if (Patterns.EMAIL_ADDRESS.matcher(edittext.text.toString()).matches()) {
                        true
                    } else {
                        edittext.error = getString(R.string.str_provide_valid_email)
                        false
                    }
                } else {
                    edittext.error = getString(R.string.str_provide_valid_email)
                    false
                }
            }

            else -> false
        }
    }

    private fun registerUser(name: String, contact: String, password: String, type: String) {
        val call = RetrofitInstance.authService.register(name, contact, password, type)
        call.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    val registerResponse = response.body()
                    if (registerResponse != null && registerResponse.success) {
                        // Navigate to verification fragment on successful registration
                        findNavController().navigate(R.id.action_registrationFragment_to_verificationFragment)
                    } else {
                        // Handle failure response (e.g., show a toast)
                    }
                } else {
                    // Handle response error (e.g., show a toast)
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                // Handle request failure (e.g., show a toast)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
    object RetrofitInstance {
        private const val BASE_URL = "https://rabt-admin.nextgcircle.com/"

        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val authService: AuthService by lazy {
            retrofit.create(AuthService::class.java)
        }
    }


    interface AuthService {

        @FormUrlEncoded
        @POST("api/mobile/auth/register")
        fun register(
            @Field("name") name: String,
            @Field("contact") contact: String,
            @Field("password") password: String,
            @Field("type") type: String
        ): Call<RegisterResponse>
    }
