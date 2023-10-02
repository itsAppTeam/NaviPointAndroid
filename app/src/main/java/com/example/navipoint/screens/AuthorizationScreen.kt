package com.example.navipoint.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navipoint.R
import com.example.navipoint.navigation.Screens
import com.example.navipoint.signin.SingInState

@Composable
fun AuthorizationScreen(
    navController: NavController,
    state: SingInState,
    signIn: () -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInErrorMessage) {
        state.signInErrorMessage?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.regimage_1),
            contentDescription = "back",
            contentScale = ContentScale.FillHeight
        )
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black.copy(alpha = 0.3f)
        ) {

        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.navi_logo),
                contentDescription = "back",
                contentScale = ContentScale.FillHeight
            )
            Button(
                modifier = Modifier.width(320.dp),
                border = BorderStroke(width = 1.dp, color = Color.White),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                onClick = {
//                    signIn()
                        navController.navigate(route = Screens.AddProfileScreen.route)
                }
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.google_icon) , contentDescription = ""
                    )
                Text(
                    modifier = Modifier
                        .padding(all = 8.dp),
                    text = "Вход c Google",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W700
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier.width(320.dp),
                border = BorderStroke(width = 1.dp, color = Color.White),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Rounded.Stars, contentDescription = "star")
                Text(
                    modifier = Modifier
                        .padding(all = 8.dp),
                    text = "Вход для администратора",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W700
                )
            }
        }


    }

}

//@Preview(showBackground = true)
//@Composable
//fun AuthPreview() {
//
//    fun test() {}
//    NaviPointTheme {
//        AuthorizationScreen(signIn = {test()})
//    }
//}