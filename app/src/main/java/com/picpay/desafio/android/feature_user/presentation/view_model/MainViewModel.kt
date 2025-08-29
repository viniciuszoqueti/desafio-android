package com.picpay.desafio.android.com.picpay.desafio.android.feature_user.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.com.picpay.desafio.android.common.NetworkResult
import com.picpay.desafio.android.feature_user.domain.UserUseCase
import com.picpay.desafio.android.feature_user.domain.exception.NetworkException
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.presentation.view_state.MainUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userUseCase: UserUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Loading)
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun loadUsers() {
        _uiState.update { MainUiState.Loading }

        viewModelScope.launch {
            val result = userUseCase.getUsers()

            when (result) {
                is NetworkResult.Success -> _uiState.update { MainUiState.Success(result.data) }

                is NetworkResult.Error -> handleError(result.exception)
            }
        }
    }

    private fun handleError(exception: Exception) {
        val errorState = when (exception) {
            is NetworkException -> MainUiState.Error.Network

            else -> MainUiState.Error.Generic
        }

        _uiState.update { errorState }
    }
}