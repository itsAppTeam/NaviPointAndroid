package com.example.navipoint.modules

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Motorcycle
import androidx.compose.material.icons.filled.SportsMotorsports
import androidx.compose.material.icons.filled.WhereToVote
import androidx.compose.material.icons.outlined.AddLocation
import androidx.compose.material.icons.outlined.AddLocationAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navipoint.R
import com.example.navipoint.ui.theme.NaviPointTheme

@Composable
fun AdminMainScreen(

) {
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
                    .padding(end = 12.dp)
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.End

            ) {
                Text(text = "Выйти", color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Default.Logout, contentDescription = "",
                    tint = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),

            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .padding(bottom = 24.dp)
                ) {
                    Text(
                        text = "Привет, Админ!",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.W700
                    )
                }

                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    onClick = {  }
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {

                    Icon(imageVector = Icons.Default.Map, contentDescription = "map")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Карта с точками", fontSize = 18.sp)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                AdminMainButtonView(
                    icon = Icons.Default.WhereToVote,
                    blockTitle = "Точки на модерацию",
                    buttonTitle = "Проверить") {
                    
                }
                Spacer(modifier = Modifier.height(16.dp))

                AdminMainButtonView(
                    icon = Icons.Default.Chat,
                    blockTitle = "Заявки на оспаривание",
                    buttonTitle = "Ответить") {

                }
                Spacer(modifier = Modifier.height(16.dp))

                AdminMainButtonView(
                    icon = Icons.Default.SportsMotorsports,
                    blockTitle = "Участники в регионе",
                    buttonTitle = "Участники") {

                }
                Spacer(modifier = Modifier.height(16.dp))

                AdminMainButtonView(
                    icon = Icons.Outlined.AddLocationAlt,
                    blockTitle = "Добавление точки",
                    buttonTitle = "Добавить") {

                }



            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AdminMainPreview() {
    NaviPointTheme {
        AdminMainScreen()
    }
}