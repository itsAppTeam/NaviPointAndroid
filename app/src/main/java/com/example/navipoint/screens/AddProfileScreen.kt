package com.example.navipoint.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navipoint.signin.UserData

@Composable
fun AddProfileScreen(
    userData: UserData,
    onSignOut: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${userData.userName}")
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            onSignOut()
        }) {
            Text(text = "Выйти")
        }
    }


}
