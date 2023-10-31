package com.example.navipoint.modules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navipoint.ui.theme.NaviPointTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminAuthScreen() {

    var login: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }


    Box {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .padding(start = 12.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos, contentDescription = "",
                    tint = Color.White

                )
                Text(text = "Назад", color = Color.White)
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Text(
                        text = "Вход админа",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.W700
                    )
                }

                Column() {
                    Text(text = "Введите логин", color = Color.White,)
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = login,
                        onValueChange = {
                            login = it
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Введите пароль", color = Color.White,)
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = password,
                        onValueChange = {
                            password = it
                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { /*TODO*/ }) {

                        Text(text = "Войти")
                    }
                }

                Text(
                    text = "Хотите стать админом и помогать нам?\n" +
                            "Заполните форму, мы с вами свяжемся.",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    textAlign = TextAlign.Center
                )


            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun AdminPreview() {
    NaviPointTheme {
        AdminAuthScreen()
    }
}