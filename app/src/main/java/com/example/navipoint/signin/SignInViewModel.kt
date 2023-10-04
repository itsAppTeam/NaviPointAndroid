package com.example.navipoint.signin

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.navipoint.datamodels.City
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel: ViewModel() {
    private val _state = MutableStateFlow(SingInState())
    val state = _state.asStateFlow()

    val citiesFlow: MutableStateFlow<List<City>> = MutableStateFlow(listOf())
    val regionsFlow: MutableStateFlow<List<String>> = MutableStateFlow(listOf())


    @OptIn(ExperimentalStdlibApi::class)
    suspend fun getCities(context: Context) {
        val json: String = context.assets.open("cities.json").bufferedReader().use { it.readText() }

        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val jsonAdapter: JsonAdapter<List<City>> = moshi.adapter<List<City>>()

        val cities = jsonAdapter.fromJson(json)
        if (cities != null) {
            citiesFlow.update { cities }
            val regions: Set<String> = cities.map { it.subject }.toSet()
            regionsFlow.update { regions.toList() }
        }
    }

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