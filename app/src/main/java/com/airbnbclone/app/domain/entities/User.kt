package com.airbnbclone.app.domain.entities

data class User(
    val id: String,
    val name: String,
    val email: String,
    val phone: String? = null,
    val avatar: String? = null,
    val createdAt: Long? = null
)

