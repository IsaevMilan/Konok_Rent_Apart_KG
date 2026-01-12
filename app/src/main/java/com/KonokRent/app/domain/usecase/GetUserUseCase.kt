package com.airbnbclone.app.domain.usecase

import com.airbnbclone.app.domain.entities.User
import com.airbnbclone.app.domain.repository.UserRepository

class GetUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(userId: String): User {
        return repository.getUser(userId)
    }
}

