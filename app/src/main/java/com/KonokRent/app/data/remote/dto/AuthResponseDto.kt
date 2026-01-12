package com.airbnbclone.app.data.remote.dto

import com.airbnbclone.app.domain.entities.User
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseDto(
    val success: Boolean,
    val token: String? = null,
    val refreshToken: String? = null,
    val user: UserDto? = null
) {
    fun toAuthResult(): com.airbnbclone.app.domain.repository.AuthResult {
        return com.airbnbclone.app.domain.repository.AuthResult(
            user = user!!.toEntity(),
            token = token!!,
            refreshToken = refreshToken!!
        )
    }
}

@Serializable
data class LoginRequestDto(
    val phone: String? = null,
    val email: String? = null,
    val password: String
)

@Serializable
data class RegisterRequestDto(
    val phone: String,
    val email: String,
    val password: String,
    val name: String
)

@Serializable
data class VerifyCodeRequestDto(
    val phone: String,
    val code: String
)

@Serializable
data class UserDto(
    val id: String,
    val name: String,
    val email: String,
    val phone: String? = null,
    val avatar: String? = null,
    val createdAt: Long? = null
) {
    fun toEntity(): User {
        return User(
            id = id,
            name = name,
            email = email,
            phone = phone,
            avatar = avatar,
            createdAt = createdAt
        )
    }
}

