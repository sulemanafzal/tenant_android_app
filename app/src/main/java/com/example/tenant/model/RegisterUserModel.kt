package com.example.tenant.model

data class RegisterUser(
    val id: Int,
    val name: String,
    val contact: String,
    val type: String,
    val otp: String
)

data class RegisterResponse(
    val success: Boolean,
    val user: RegisterUser,
    val message: String
)
