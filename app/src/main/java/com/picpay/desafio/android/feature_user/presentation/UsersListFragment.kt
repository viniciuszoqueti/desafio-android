package com.picpay.desafio.android.feature_user.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.picpay.desafio.android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersListFragment : Fragment(R.layout.fragment_users_list) {

    private val viewModel by viewModels<UsersListViewModel>()
}