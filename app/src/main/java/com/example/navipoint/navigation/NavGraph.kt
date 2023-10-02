package com.example.navipoint.navigation

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navipoint.screens.AddProfileScreen
import com.example.navipoint.screens.AuthorizationScreen
import com.example.navipoint.signin.GoogleAuthUIClient
import com.example.navipoint.signin.SignInViewModel
import com.example.navipoint.signin.UserData
import kotlinx.coroutines.launch

@Composable

fun NavGraph(
    navController: NavHostController,
    googleAuthUiClient: GoogleAuthUIClient

) {
    val context = LocalContext.current
    var startDestination = Screens.AuthorizationScreen.route
    val coroutineScope = rememberCoroutineScope()

    NavHost(navController = navController, startDestination = startDestination) {
        composable("auth_screen") {
            val viewModel = viewModel<SignInViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = {result ->
                    if(result.resultCode == Activity.RESULT_OK) {
                        coroutineScope.launch {
                            val signInResult = googleAuthUiClient.getSignInWithIntent(
                                intent = result.data ?: return@launch
                            )
                        }
                    }
                })
            

            AuthorizationScreen(navController = navController, state = state) {
                coroutineScope.launch {
                    val signInIntentSender = googleAuthUiClient.signIn()
                    launcher.launch(
                        IntentSenderRequest.Builder(
                            intentSender = signInIntentSender ?: return@launch
                        ).build()
                    )
                }
            }
        }
        composable("add_profile") {
            AddProfileScreen(userData = UserData(userId = "", userName = null, profilePictureUrl = null)) {

            }
//            AddProfileScreen(
//                userData = googleAuthUiClient.getSignInUser()
//            ) {
//                coroutineScope.launch {
//                    googleAuthUiClient.sidnOut()
//                }
//
//            }
        }
    }

}