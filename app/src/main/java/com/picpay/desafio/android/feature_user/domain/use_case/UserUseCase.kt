package com.picpay.desafio.android.feature_user.domain

import com.picpay.desafio.android.com.picpay.desafio.android.common.NetworkResult
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.model.UserDomainModel
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.repository.UserRepository
import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : UserUseCase {

    override suspend fun getUsers(): NetworkResult<List<UserDomainModel>> {
        return userRepository.getUsers()
    }
}

interface UserUseCase {
    suspend fun getUsers(): NetworkResult<List<UserDomainModel>>
}