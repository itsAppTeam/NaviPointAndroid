package com.example.navipoint.screens


import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navipoint.R
import com.example.navipoint.signin.SignInViewModel
import com.example.navipoint.signin.UserData
import com.example.navipoint.tools.Regions
import com.example.navipoint.ui.theme.NaviPointTheme

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProfileScreen(
    signInViewModel: SignInViewModel,
    userData: UserData,
    onSignOut: () -> Unit
) {
    val context = LocalContext.current


    var name: String by remember { mutableStateOf("") }
    var phone: String by remember { mutableStateOf("") }

    val cities = signInViewModel.citiesFlow.collectAsState()
    LaunchedEffect(key1 = "", block = {
        signInViewModel.getCities(context = context)

    })


    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedGroup: String by remember {
        mutableStateOf(
            "")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Города //// ${cities.value.count()}", color = Color.White)
        Text(text = "Города //// ${signInViewModel.regionsFlow.value.count()}", color = Color.White)

        Text(
            modifier = Modifier.padding(bottom = 40.dp),
            text = "Создание профиля",
            color = Color.White,
            fontWeight = W500,
            fontSize = 24.sp
        )

        Box(
            modifier = Modifier
                .padding(bottom = 40.dp)
                .size(120.dp)
                .background(
                    color = colorResource(id = R.color.viola),
                    RoundedCornerShape(percent = 50)
                )
                .border(
                    border = BorderStroke(width = 2.dp, color = Color.White),
                    shape = CircleShape
                )
            ,
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .background(color = Color.White, shape = CircleShape)
                    .padding(all = 4.dp),
                imageVector = Icons.Default.Person, contentDescription = "person"
            )
        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = name,
            onValueChange = { name = it },
            maxLines = 1,
            label = {
                Text(
                    text = "Укажите никнейм",
                    fontSize = 14.sp,
                    maxLines = 1
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                focusedLabelColor = colorResource(id = R.color.navi_orange),
                focusedBorderColor = colorResource(id = R.color.navi_orange)
            )
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = phone,
            onValueChange = { phone = it },
            maxLines = 1,
            label = {
                Text(
                    text = "Укажите номер для общения",
                    fontSize = 14.sp,
                    maxLines = 1
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                focusedLabelColor = colorResource(id = R.color.navi_orange),
                focusedBorderColor = colorResource(id = R.color.navi_orange)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
        )
        ExposedDropdownMenuBox(

            modifier = Modifier
                .fillMaxWidth(),
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {


            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
                ,
                value = selectedGroup,
                readOnly = false,
                onValueChange = {selectedGroup = it},
                label = {
                    Text(text = "") }
                ,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
//                    Icon(imageVector = Icons.Default.ExpandMore, contentDescription ="" )
                }
                ,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedLabelColor = colorResource(id = R.color.navi_orange),
                    focusedBorderColor = colorResource(id = R.color.navi_orange)
                )
            )


            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },

                ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    signInViewModel.regionsFlow.value.sorted().forEach() {
                        it
                        DropdownMenuItem(text = {Text(text = it, fontSize = 24.sp) }, onClick = {
                            selectedGroup = it
                            expanded = false
                        })

                    }
                }
            }
        }



        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier
                .width(269.dp)
                .padding(bottom = 24.dp)
            ,
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.navi_orange)),
            onClick = {
                onSignOut()
            }) {
            Icon(imageVector = Icons.Default.PersonAdd, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                modifier = Modifier
                    .padding(vertical = 12.dp),
                text = "Создать",
                fontSize = 17.sp,
                fontWeight = W700
            )
        }


        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = colorResource(
                id = R.color.dark_backfound
            ))
        ) {
            Text(text = "Политика конфиденциальности")
        }

        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = colorResource(
                id = R.color.dark_backfound
            ))
        ) {
            Text(text = "Правила обработки данныхости")
        }

    }
}

//
//@Preview(showBackground = true, backgroundColor = 12.3.toLong())
//@Composable
//fun AddProfileScreenPreview() {
//
//    fun test() {}
//    NaviPointTheme {
//        AddProfileScreen(
//            userData = UserData(
//                userId = "113",
//                userName = "Hey",
//                profilePictureUrl = ""
//            )
//        ) {
//
//        }
//    }
//}