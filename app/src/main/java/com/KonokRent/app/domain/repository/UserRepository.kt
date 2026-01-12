package com.airbnbclone.app.domain.repository

import com.airbnbclone.app.domain.entities.User

interface UserRepository {
    suspend fun getUser(userId: String): User
    suspend fun updateUser(user: User): User
    suspend fun changePassword(userId: String, currentPassword: String, newPassword: String)
    suspend fun getPrivacySettings(userId: String): PrivacySettings
    suspend fun updatePrivacySettings(userId: String, settings: PrivacySettings)
    suspend fun getAppSettings(userId: String): AppSettings
    suspend fun updateAppSettings(userId: String, settings: AppSettings)
    suspend fun getPermissions(userId: String): Permissions
    suspend fun updatePermissions(userId: String, permissions: Permissions)
}

data class PrivacySettings(
    val profileVisibility: Boolean,
    val showEmail: Boolean,
    val showPhone: Boolean,
    val allowMessages: Boolean,
    val showActivity: Boolean
)

data class AppSettings(
    val notificationsEnabled: Boolean,
    val emailNotifications: Boolean,
    val pushNotifications: Boolean,
    val language: String,
    val theme: String
)

data class Permissions(
    val camera: Boolean,
    val location: Boolean,
    val notifications: Boolean,
    val storage: Boolean
)

