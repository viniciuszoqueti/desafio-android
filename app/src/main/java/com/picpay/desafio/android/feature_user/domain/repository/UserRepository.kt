package com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.repository

import com.picpay.desafio.android.com.picpay.desafio.android.common.NetworkResult
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.model.UserDomainModel

interface UserRepository {
    suspend fun getUsers(): NetworkResult<List<UserDomainModel>>
}