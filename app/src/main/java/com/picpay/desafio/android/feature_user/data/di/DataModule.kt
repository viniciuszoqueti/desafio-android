package com.picpay.desafio.android.feature_user.data.di

import com.picpay.desafio.android.feature_user.data.UserRepositoryImpl
import com.picpay.desafio.android.feature_user.domain.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}
