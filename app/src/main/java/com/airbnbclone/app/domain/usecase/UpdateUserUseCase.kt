package com.airbnbclone.app.domain.usecase

import com.airbnbclone.app.domain.entities.User
import com.airbnbclone.app.domain.repository.UserRepository

class UpdateUserUseCase(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User): User {
        return repository.updateUser(user)
    }
}

