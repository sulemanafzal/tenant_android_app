package com.example.tenant.model

data class LoginResponse(
    val success: Boolean,
    val otp: String,
    val message: String
)
