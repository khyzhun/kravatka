package com.khyzhun.kravatka.pages.sign_in

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {

    fun loginRequest(login: String, password: String): Boolean {
        return (login == "test@test.com" && password == "password")
    }

}
