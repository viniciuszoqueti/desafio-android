package com.picpay.desafio.android.feature_user.data

import com.picpay.desafio.android.feature_user.domain.UserDomainModel
import com.picpay.desafio.android.feature_user.domain.UserRepository
import com.picpay.desafio.android.feature_user.domain.exception.GeneralException
import com.picpay.desafio.android.feature_user.domain.exception.NetworkException
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService
) : UserRepository {

    override suspend fun getUsers(): NetworkResult<List<UserDomainModel>> {
        return try {
            val response = userApiService.getUsers()
            NetworkResult.Success(response.map { it.toDomainModel() })
        } catch (e: IOException) {
            NetworkResult.Error(NetworkException(e))
        } catch (e: Exception) {
            NetworkResult.Error(GeneralException(e))
        }
    }
}