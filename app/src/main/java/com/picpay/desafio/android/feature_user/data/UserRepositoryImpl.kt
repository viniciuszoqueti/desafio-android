package com.picpay.desafio.android.feature_user.data

import com.picpay.desafio.android.feature_user.domain.UserDomainModel
import com.picpay.desafio.android.feature_user.domain.UserRepository
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
            NetworkResult.Error(Exception("Erro de conexão, verifique sua conexão com a internet", e))
        } catch (e: Exception) {
            NetworkResult.Error(Exception("Erro, tente novamente mais tarde", e))
        }
    }
}