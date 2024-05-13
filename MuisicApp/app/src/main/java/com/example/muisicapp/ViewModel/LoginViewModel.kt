package com.example.muisicapp.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.muisicapp.Model.repository.MusicRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class LoginViewModel(
//    val userDao: MusicDao,
//    val context: Context,
//    val navController: NavController,
    musicRepository: MusicRepository,

    ) : ViewModel() {

    var loginUiState by mutableStateOf(UserUiState())

    fun updateUiState(userName: String, password: String) {
        loginUiState = UserUiState(userName, password)
    }

    val userUiState: StateFlow<Users> = musicRepository.getAllUser().map { Users(it) }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000L),
        initialValue = Users()
    )

    fun login(): Boolean {
        var userName = loginUiState.userName
        var passWord = loginUiState.password

        return if (userName == userUiState.value.userName && passWord == userUiState.value.password) {
            true
        } else {
            false
        }
    }

//    fun login(email: String, password: String) {
//        viewModelScope.launch {
//            val user = musicRepository.checkLogin(email, password)
//            if (user != null) {
//                navController.navigate(HomeDestination.route)
//            } else {
//                Toast.makeText(context, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}

data class UserUiState(
    val userName: String = "", val password: String = ""
)

data class Users(
    val userID: Int = 0,
    val fullName: String = "",
    val userName: String = "",
    val password: String = "",
)

