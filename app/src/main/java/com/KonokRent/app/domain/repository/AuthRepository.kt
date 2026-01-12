package com.airbnbclone.app.domain.repository

import com.airbnbclone.app.domain.entities.User

interface AuthRepository {
    suspend fun login(phoneOrEmail: String, password: String): AuthResult
    suspend fun register(
        phone: String,
        email: String,
        password: String,
        name: String
    ): AuthResult
    suspend fun sendVerificationCode(phone: String)
    suspend fun verifyCode(phone: String, code: String): AuthResult
    suspend fun socialLogin(provider: String, token: String): AuthResult
    suspend fun refreshToken(refreshToken: String): TokenPair
    suspend fun logout()
    suspend fun getCurrentUser(): User?
}

data class AuthResult(
    val user: User,
    val token: String,
    val refreshToken: String
)

data class TokenPair(
    val token: String,
    val refreshToken: String
)

