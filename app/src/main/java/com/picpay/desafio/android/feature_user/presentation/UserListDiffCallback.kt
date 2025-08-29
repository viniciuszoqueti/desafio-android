package com.picpay.desafio.android.feature_user.presentation

import androidx.recyclerview.widget.DiffUtil
import com.picpay.desafio.android.feature_user.domain.UserDomainModel

class UserListDiffCallback(
    private val oldList: List<UserDomainModel>,
    private val newList: List<UserDomainModel>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].username == newList[newItemPosition].username
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}