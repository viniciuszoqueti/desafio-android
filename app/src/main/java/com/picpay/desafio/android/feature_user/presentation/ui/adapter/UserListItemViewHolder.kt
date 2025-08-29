package com.picpay.desafio.android.feature_user.presentation

import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.com.picpay.desafio.android.feature_user.domain.model.UserDomainModel

class UserListItemViewHolder(private val binding: ListItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(user: UserDomainModel) {
        binding.name.text = user.name
        binding.username.text = user.username
        binding.email.text = user.email
        binding.phone.text = user.phone
    }
}