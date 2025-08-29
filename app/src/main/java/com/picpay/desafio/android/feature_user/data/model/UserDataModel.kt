package com.picpay.desafio.android.com.picpay.desafio.android.feature_user.data.model

import com.google.gson.annotations.SerializedName

data class UserDataModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String
)