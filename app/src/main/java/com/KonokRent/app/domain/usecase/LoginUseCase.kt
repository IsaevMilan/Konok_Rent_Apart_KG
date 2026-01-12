package com.airbnbclone.app.domain.usecase

import com.airbnbclone.app.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(phoneOrEmail: String, password: String) =
        repository.login(phoneOrEmail, password)
}

