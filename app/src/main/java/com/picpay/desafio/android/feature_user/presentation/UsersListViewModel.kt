package com.picpay.desafio.android.feature_user.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.feature_user.data.NetworkResult
import com.picpay.desafio.android.feature_user.domain.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {

    fun loadUsers() {
        viewModelScope.launch {
            val result = userUseCase.getUsers()

            when (result) {
                is NetworkResult.Success -> {
                    // implementar sucesso
                }

                is NetworkResult.Error -> {
                    // implementar erro
                }
            }
        }
    }
}