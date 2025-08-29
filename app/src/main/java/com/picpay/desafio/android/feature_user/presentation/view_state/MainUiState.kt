package com.picpay.desafio.android.com.picpay.desafio.android.feature_user.presentation.view_state

import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.model.UserDomainModel

sealed interface MainUiState {
    object Loading : MainUiState
    data class Success(val users: List<UserDomainModel>) : MainUiState
    sealed interface Error : MainUiState {
        object Generic : Error
        object Network : Error
    }
}