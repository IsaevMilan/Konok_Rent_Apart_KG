package com.airbnbclone.app.data.repository.mock

import com.airbnbclone.app.domain.entities.User
import com.airbnbclone.app.domain.repository.AppSettings
import com.airbnbclone.app.domain.repository.Permissions
import com.airbnbclone.app.domain.repository.PrivacySettings
import com.airbnbclone.app.domain.repository.UserRepository

class MockUserRepository : UserRepository {
    
    override suspend fun getUser(userId: String): User {
        kotlinx.coroutines.delay(300)
        return User(
            id = userId,
            name = "Иван Иванов",
            email = "ivan@example.com",
            phone = "+79991234567",
            avatar = null,
            createdAt = System.currentTimeMillis() - 86400000L * 365
        )
    }
    
    override suspend fun updateUser(user: User): User {
        kotlinx.coroutines.delay(400)
        return user
    }
    
    override suspend fun changePassword(userId: String, currentPassword: String, newPassword: String) {
        kotlinx.coroutines.delay(400)
    }
    
    override suspend fun getPrivacySettings(userId: String): PrivacySettings {
        kotlinx.coroutines.delay(200)
        return PrivacySettings(
            profileVisibility = true,
            showEmail = false,
            showPhone = false,
            allowMessages = true,
            showActivity = true
        )
    }
    
    override suspend fun updatePrivacySettings(userId: String, settings: PrivacySettings) {
        kotlinx.coroutines.delay(300)
    }
    
    override suspend fun getAppSettings(userId: String): AppSettings {
        kotlinx.coroutines.delay(200)
        return AppSettings(
            notificationsEnabled = true,
            emailNotifications = true,
            pushNotifications = true,
            language = "ru",
            theme = "light"
        )
    }
    
    override suspend fun updateAppSettings(userId: String, settings: AppSettings) {
        kotlinx.coroutines.delay(300)
    }
    
    override suspend fun getPermissions(userId: String): Permissions {
        kotlinx.coroutines.delay(200)
        return Permissions(
            camera = true,
            location = true,
            notifications = true,
            storage = true
        )
    }
    
    override suspend fun updatePermissions(userId: String, permissions: Permissions) {
        kotlinx.coroutines.delay(300)
    }
}

