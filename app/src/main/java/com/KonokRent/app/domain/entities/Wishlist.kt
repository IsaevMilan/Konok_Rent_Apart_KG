package com.airbnbclone.app.domain.entities

data class Wishlist(
    val id: String,
    val userId: String,
    val name: String,
    val description: String? = null,
    val isPublic: Boolean,
    val itemsCount: Int,
    val coverImage: String? = null,
    val createdAt: Long
)

