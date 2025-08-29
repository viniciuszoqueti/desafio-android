package com.picpay.desafio.android.feature_user.data

import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.data.model.UserDataModel
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.model.UserDomainModel

fun UserDataModel.toDomainModel(): UserDomainModel {
    return UserDomainModel(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        phone = this.phone
    )
}