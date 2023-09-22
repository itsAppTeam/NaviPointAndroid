package com.example.navipoint.signin

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel: ViewModel() {
    private val _state = MutableStateFlow(SingInState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: SignInResult) {
        _state.update {it.copy(
            isSignInSuccess = result.data != null,
            signInErrorMessage = result.errorMessage

        ) }
    }
    fun resetState() {
        _state.update { SingInState() }
    }
}