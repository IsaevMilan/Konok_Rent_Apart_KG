package com.airbnbclone.app.domain.entities

data class Review(
    val id: String,
    val listingId: String,
    val userId: String,
    val userName: String,
    val userAvatar: String? = null,
    val rating: Int,
    val comment: String,
    val createdAt: Long
)

