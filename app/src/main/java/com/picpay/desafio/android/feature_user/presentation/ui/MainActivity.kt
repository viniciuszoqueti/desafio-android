package com.picpay.desafio.android.com.picpay.desafio.android.feature_user.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.presentation.view_model.MainViewModel
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.presentation.view_state.MainUiState
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.feature_user.presentation.UserListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val userListAdapter = UserListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpUI()
        setUpObservers()
        setUpListeners()

        if (savedInstanceState == null) viewModel.loadUsers()
    }

    private fun setUpUI() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setUpObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                binding.userListProgressBar.visibility = View.GONE
                binding.recyclerView.visibility = View.GONE
                binding.errorContainer.visibility = View.GONE

                when (state) {
                    is MainUiState.Loading -> {
                        binding.userListProgressBar.visibility = View.VISIBLE
                    }

                    is MainUiState.Success -> {
                        userListAdapter.users = state.users
                        binding.recyclerView.visibility = View.VISIBLE
                    }

                    is MainUiState.Error.Generic -> {
                        binding.errorContainer.visibility = View.VISIBLE
                        binding.errorMessage.text = getString(R.string.error_generic)
                    }

                    is MainUiState.Error.Network -> {
                        binding.errorContainer.visibility = View.VISIBLE
                        binding.errorMessage.text = getString(R.string.error_network)
                    }
                }
            }
        }
    }

    private fun setUpListeners() {
        binding.retryButton.setOnClickListener {
            viewModel.loadUsers()
        }
    }
}