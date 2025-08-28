package com.picpay.desafio.android.feature_user.domain

import com.picpay.desafio.android.feature_user.data.NetworkResult

interface UserRepository {
    suspend fun getUsers(): NetworkResult<List<UserDomainModel>>
}