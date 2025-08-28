package com.picpay.desafio.android.feature_user.data

import retrofit2.http.GET

interface UserApiService {

    @GET("users")
    suspend fun getUsers(): List<UserDataModel>
}