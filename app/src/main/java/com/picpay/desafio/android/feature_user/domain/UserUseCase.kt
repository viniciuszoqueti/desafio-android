package com.picpay.desafio.android.feature_user.domain

import com.picpay.desafio.android.feature_user.data.NetworkResult
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