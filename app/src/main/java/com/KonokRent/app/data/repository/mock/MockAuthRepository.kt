package com.airbnbclone.app.data.repository.mock

import com.airbnbclone.app.domain.entities.User
import com.airbnbclone.app.domain.repository.AuthRepository
import com.airbnbclone.app.domain.repository.AuthResult
import com.airbnbclone.app.domain.repository.TokenPair

class MockAuthRepository : AuthRepository {
    
    override suspend fun login(phoneOrEmail: String, password: String): AuthResult {
        kotlinx.coroutines.delay(500) // Имитация сети
        return AuthResult(
            user = User(
                id = "user1",
                name = "Тестовый Пользователь",
                email = phoneOrEmail.takeIf { it.contains("@") } ?: "test@example.com",
                phone = phoneOrEmail.takeUnless { it.contains("@") } ?: "+79991234567"
            ),
            token = "mock_token_${System.currentTimeMillis()}",
            refreshToken = "mock_refresh_token_${System.currentTimeMillis()}"
        )
    }
    
    override suspend fun register(
        phone: String,
        email: String,
        password: String,
        name: String
    ): AuthResult {
        kotlinx.coroutines.delay(500)
        return AuthResult(
            user = User(
                id = "user_${System.currentTimeMillis()}",
                name = name,
                email = email,
                phone = phone
            ),
            token = "mock_token_${System.currentTimeMillis()}",
            refreshToken = "mock_refresh_token_${System.currentTimeMillis()}"
        )
    }
    
    override suspend fun sendVerificationCode(phone: String) {
        kotlinx.coroutines.delay(300)
    }
    
    override suspend fun verifyCode(phone: String, code: String): AuthResult {
        kotlinx.coroutines.delay(500)
        return AuthResult(
            user = User(
                id = "user_${System.currentTimeMillis()}",
                name = "Пользователь",
                email = "user@example.com",
                phone = phone
            ),
            token = "mock_token_${System.currentTimeMillis()}",
            refreshToken = "mock_refresh_token_${System.currentTimeMillis()}"
        )
    }
    
    override suspend fun socialLogin(provider: String, token: String): AuthResult {
        kotlinx.coroutines.delay(500)
        return AuthResult(
            user = User(
                id = "user_${System.currentTimeMillis()}",
                name = "Social User",
                email = "social@example.com"
            ),
            token = "mock_token_${System.currentTimeMillis()}",
            refreshToken = "mock_refresh_token_${System.currentTimeMillis()}"
        )
    }
    
    override suspend fun refreshToken(refreshToken: String): TokenPair {
        kotlinx.coroutines.delay(300)
        return TokenPair(
            token = "new_mock_token_${System.currentTimeMillis()}",
            refreshToken = "new_mock_refresh_token_${System.currentTimeMillis()}"
        )
    }
    
    override suspend fun logout() {
        kotlinx.coroutines.delay(200)
    }
    
    override suspend fun getCurrentUser(): User? {
        return User(
            id = "user1",
            name = "Текущий Пользователь",
            email = "current@example.com",
            phone = "+79991234567"
        )
    }
}

