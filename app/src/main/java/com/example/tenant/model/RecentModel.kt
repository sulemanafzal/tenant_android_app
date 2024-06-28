package com.example.tenant.model

data class RecentModel(
    val id: String,
    val complaint_id: String,
    val title: String,
    val status: String,
    val statusIndicatorColor: Int,
    val postDate: String,
    val postTime: String
)