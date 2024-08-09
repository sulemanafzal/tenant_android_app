package com.example.tenant.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenant.R
import com.example.tenant.databinding.FragmentSignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Patterns
import android.widget.Toast
import com.example.tenant.fragment.RetrofitInstance
import com.example.tenant.model.LoginResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()

            if (validateInput(name, email)) {
                loginUser(name, email)
            }
        }

        return binding.root
    }

    private fun validateInput(name: String, email: String): Boolean {
        var isValid = true

        if (name.isEmpty()) {
            binding.etName.error = getString(R.string.str_name_required)
            isValid = false
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmail.error = getString(R.string.str_provide_valid_email)
            isValid = false
        }

        return isValid
    }

    private fun loginUser(name: String, email: String) {
        val call = RetrofitInstance.authService.login(name, email)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null && loginResponse.success) {
                        // Login successful, navigate to the verification fragment
                        val destinationFragment = arguments?.getInt("destinationFragment")
                        if (destinationFragment != null) {
                            findNavController().navigate(destinationFragment)
                        }
                    } else {
                        // Login failed, show error message from the response
                        val errorMessage = loginResponse?.message ?: getString(R.string.str_name_required)
                        showError(errorMessage)
                    }
                } else {
                    // Response error, show a generic error message
                    showError(getString(R.string.str_provide_valid_email))
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Request failure, show a network error message
                showError(getString(R.string.str_name_required))
            }
        })
    }

    private fun showError(message: String) {
        // Show the error message to the user
        Toast.makeText(requireContext(), "not valid email", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface AuthService {
        @FormUrlEncoded
        @POST("api/mobile/auth/login")
        fun login(
            @Field("name") name: String,
            @Field("email") email: String
        ): Call<LoginResponse>
    }
    object RetrofitInstance {
        private const val BASE_URL = "https://rabt-admin.nextgcircle.com/"
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val authService: AuthService by lazy {
            retrofit.create(AuthService::class.java)
        }
    }
}
