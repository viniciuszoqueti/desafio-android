package com.picpay.desafio.android.feature_user.presentation

import com.picpay.desafio.android.feature_user.domain.UserDomainModel

sealed interface MainUiState {
    object Loading : MainUiState
    data class Success(val users: List<UserDomainModel>) : MainUiState
    sealed interface Error : MainUiState {
        object Generic : Error
        object Network : Error
    }
}