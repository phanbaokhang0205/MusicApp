package com.example.muisicapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.data.MusicDao
import kotlinx.coroutines.launch

class LoginViewModel(private val userDao: MusicDao) : ViewModel() {
    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = userDao.checkLogin(email, password)
            if (user != null) {

            } else {
                // Đăng nhập thất bại
            }
        }
    }
}
