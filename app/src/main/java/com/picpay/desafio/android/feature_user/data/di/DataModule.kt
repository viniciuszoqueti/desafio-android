package com.picpay.desafio.android.feature_user.data.di

import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.data.repository.UserRepositoryImpl
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.data.service.UserApiService
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserRepository(userApiService: UserApiService): UserRepository =
        UserRepositoryImpl(userApiService)

    @Provides
    @Singleton
    fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }
}
