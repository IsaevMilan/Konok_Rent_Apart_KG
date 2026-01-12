package com.airbnbclone.app.data.repository

import com.airbnbclone.app.data.remote.api.AuthApi
import com.airbnbclone.app.domain.repository.AuthRepository
import com.airbnbclone.app.domain.repository.AuthResult
import com.airbnbclone.app.domain.repository.TokenPair
import com.airbnbclone.app.domain.entities.User
import com.airbnbclone.app.data.remote.dto.LoginRequestDto
import com.airbnbclone.app.data.remote.dto.RegisterRequestDto
import com.airbnbclone.app.data.remote.dto.VerifyCodeRequestDto

class AuthRepositoryImpl(
    private val authApi: AuthApi
) : AuthRepository {
    
    override suspend fun login(phoneOrEmail: String, password: String): AuthResult {
        val request = if (phoneOrEmail.contains("@")) {
            LoginRequestDto(email = phoneOrEmail, password = password)
        } else {
            LoginRequestDto(phone = phoneOrEmail, password = password)
        }
        return authApi.login(request).toAuthResult()
    }
    
    override suspend fun register(
        phone: String,
        email: String,
        password: String,
        name: String
    ): AuthResult {
        val request = RegisterRequestDto(phone, email, password, name)
        return authApi.register(request).toAuthResult()
    }
    
    override suspend fun sendVerificationCode(phone: String) {
        authApi.sendVerificationCode(phone)
    }
    
    override suspend fun verifyCode(phone: String, code: String): AuthResult {
        val request = VerifyCodeRequestDto(phone, code)
        return authApi.verifyCode(request).toAuthResult()
    }
    
    override suspend fun socialLogin(provider: String, token: String): AuthResult {
        // TODO: Implement
        throw NotImplementedError()
    }
    
    override suspend fun refreshToken(refreshToken: String): TokenPair {
        // TODO: Implement
        throw NotImplementedError()
    }
    
    override suspend fun logout() {
        // TODO: Implement
    }
    
    override suspend fun getCurrentUser(): User? {
        // TODO: Implement - get from local storage
        return null
    }
}

