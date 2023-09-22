package com.example.navipoint.signin

import com.google.android.gms.tasks.OnSuccessListener

data class SingInState(
    val isSignInSuccess: Boolean = false,
    val signInErrorMessage: String? = null
)
