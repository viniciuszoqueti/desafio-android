package com.picpay.desafio.android

import com.picpay.desafio.android.com.picpay.desafio.android.common.NetworkResult
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.model.UserDomainModel
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.presentation.view_model.MainViewModel
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.presentation.view_state.MainUiState
import com.picpay.desafio.android.feature_user.domain.UserUseCase
import com.picpay.desafio.android.feature_user.domain.exception.NetworkException
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {
    @RelaxedMockK
    private lateinit var userUseCase: UserUseCase

    private lateinit var viewModel: MainViewModel

    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(userUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun givenMainViewModel_whenCallLoadUsers_thenReturnsSuccessState() = runTest {
        val fakeList = listOf<UserDomainModel>()
        coEvery { userUseCase.getUsers() } returns NetworkResult.Success(fakeList)

        val states = mutableListOf<MainUiState>()
        val job = launch(testDispatcher) {
            viewModel.uiState.collect { states.add(it) }
        }

        viewModel.loadUsers()
        advanceUntilIdle()

        val expectedStates = listOf(
            MainUiState.Loading,
            MainUiState.Success(fakeList)
        )

        assertEquals(expectedStates, states)
        job.cancel()
    }

    @Test
    fun givenMainViewModel_whenCallLoadUsers_thenReturnsNetworkErrorState() = runTest {
        coEvery { userUseCase.getUsers() } returns NetworkResult.Error(NetworkException(Throwable()))

        val states = mutableListOf<MainUiState>()
        val job = launch(testDispatcher) {
            viewModel.uiState.collect { states.add(it) }
        }

        viewModel.loadUsers()
        advanceUntilIdle()

        val expectedStates = listOf(
            MainUiState.Loading,
            MainUiState.Error.Network
        )

        assertEquals(expectedStates, states)
        job.cancel()
    }

    @Test
    fun givenMainViewModel_whenCallLoadUsers_thenReturnsGenericErrorState() = runTest {
        coEvery { userUseCase.getUsers() } returns NetworkResult.Error(Exception())

        val states = mutableListOf<MainUiState>()
        val job = launch(testDispatcher) {
            viewModel.uiState.collect { states.add(it) }
        }

        viewModel.loadUsers()
        advanceUntilIdle()

        val expectedStates = listOf(
            MainUiState.Loading,
            MainUiState.Error.Generic
        )

        assertEquals(expectedStates, states)
        job.cancel()
    }
}