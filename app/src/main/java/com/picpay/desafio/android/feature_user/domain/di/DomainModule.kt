package com.picpay.desafio.android.feature_user.domain.di

import com.picpay.desafio.android.feature_user.domain.UserUseCase
import com.picpay.desafio.android.feature_user.domain.UserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun bindUserUseCase(userUseCaseImpl: UserUseCaseImpl): UserUseCase
}
