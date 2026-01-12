package com.airbnbclone.app.di

import com.airbnbclone.app.data.repository.mock.MockAuthRepository
import com.airbnbclone.app.data.repository.mock.MockUserRepository
import com.airbnbclone.app.data.repository.mock.MockMessageRepository
import com.airbnbclone.app.data.repository.mock.MockListingRepository
import com.airbnbclone.app.domain.repository.AuthRepository
import com.airbnbclone.app.domain.repository.UserRepository
import com.airbnbclone.app.domain.repository.MessageRepository
import com.airbnbclone.app.domain.repository.ListingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    
    // Используем моки для разработки
    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository {
        return MockAuthRepository()
        // Для продакшена: return AuthRepositoryImpl(authApi)
    }
    
    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository {
        return MockUserRepository()
        // Для продакшена: return UserRepositoryImpl(userApi)
    }
    
    @Provides
    @Singleton
    fun provideMessageRepository(): MessageRepository {
        return MockMessageRepository()
    }
    
    @Provides
    @Singleton
    fun provideListingRepository(): ListingRepository {
        return MockListingRepository()
    }
}

