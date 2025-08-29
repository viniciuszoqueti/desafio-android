package com.picpay.desafio.android.com.picpay.desafio.android.feature_user.data.service

import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.data.model.UserDataModel
import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): List<UserDataModel>
}