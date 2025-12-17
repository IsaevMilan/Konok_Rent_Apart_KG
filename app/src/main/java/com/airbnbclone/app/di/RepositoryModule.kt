package com.airbnbclone.app.di

import com.airbnbclone.app.data.repository.AuthRepositoryImpl
import com.airbnbclone.app.data.repository.UserRepositoryImpl
import com.airbnbclone.app.domain.repository.AuthRepository
import com.airbnbclone.app.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
    
    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}

