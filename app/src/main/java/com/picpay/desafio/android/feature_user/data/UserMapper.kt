package com.picpay.desafio.android.feature_user.data

import com.picpay.desafio.android.feature_user.domain.UserDomainModel

fun UserDataModel.toDomainModel(): UserDomainModel {
    return UserDomainModel(
        id = this.id,
        name = this.name,
        username = this.username,
        email = this.email,
        address = UserDomainModel.Address(
            street = this.address.street,
            suite = this.address.suite,
            city = this.address.city,
            zipcode = this.address.zipcode,
            geo = UserDomainModel.Geo(
                lat = this.address.geo.lat,
                lng = this.address.geo.lng
            )
        ),
        phone = this.phone,
        website = this.website,
        company = UserDomainModel.Company(
            name = this.company.name,
            catchPhrase = this.company.catchPhrase,
            bs = this.company.bs
        )
    )
}