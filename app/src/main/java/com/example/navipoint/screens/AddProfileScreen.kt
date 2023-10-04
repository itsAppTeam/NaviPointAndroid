package com.example.navipoint.screens


import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.example.navipoint.R
import com.example.navipoint.signin.SignInViewModel
import com.example.navipoint.signin.UserData
import kotlinx.coroutines.flow.filter

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
    var selectedRegion: String by remember { mutableStateOf("") }
    var selectedCity: String by remember { mutableStateOf("") }
    var warningMessge: String by remember { mutableStateOf("") }



    LaunchedEffect(key1 = "", block = {
        signInViewModel.getCities(context = context)

    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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
                ),
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
            onValueChange = {
                name = it
                warningMessge = ""
            },
            maxLines = 1,
            label = {
                Text(
                    text = "Укажите никнейм",
                    fontSize = 14.sp,
                    maxLines = 1,
                    color = Color.LightGray
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
            onValueChange = {
                phone = it
                warningMessge = ""
            },
            maxLines = 1,
            label = {
                Text(
                    text = "Укажите номер для общения",
                    fontSize = 14.sp,
                    maxLines = 1,
                    color = Color.LightGray
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                focusedLabelColor = colorResource(id = R.color.navi_orange),
                focusedBorderColor = colorResource(id = R.color.navi_orange)
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
        )

        var expanded by remember {
            mutableStateOf(false)
        }


        var expandedForCity by remember {
            mutableStateOf(false)
        }


        val filteringOptions = signInViewModel.regionsFlow.value.filter {
            it.contains(
                selectedRegion,
                ignoreCase = true
            )
        }
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
                    .menuAnchor(),
                value = selectedRegion,
                readOnly = false,
                onValueChange = {
                    selectedRegion = it
                    expanded = true
                    warningMessge = ""
                },
                maxLines = 1,
                label = {
                    Text(
                        text = "Укажите Регион",
                        color = Color.LightGray
                    )
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
//                    Icon(imageVector = Icons.Default.ExpandMore, contentDescription ="" )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedLabelColor = colorResource(id = R.color.navi_orange),
                    focusedBorderColor = colorResource(id = R.color.navi_orange)
                )
            )

            if (filteringOptions.isNotEmpty()) {
                DropdownMenu(
                    modifier = Modifier
                        .exposedDropdownSize(true),
                    properties = PopupProperties(focusable = false),
                    expanded = expanded,
                    onDismissRequest = { expanded = false },

                    ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        filteringOptions.forEach() {
                            it
                            Log.d("Moped", "${filteringOptions}")
                            DropdownMenuItem(
                                text = { Text(text = it, fontSize = 14.sp) },
                                onClick = {
                                    selectedRegion = it
                                    expanded = false
                                    warningMessge = ""
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )

                        }
                    }
                }
            }
        }
        if (selectedRegion.isNotEmpty() && signInViewModel.regionsFlow.value.contains(selectedRegion)) {

            val filteringCities = signInViewModel.citiesFlow.value.filter {
                it.subject == selectedRegion &&
                        it.name.contains(selectedCity)
            }
            ExposedDropdownMenuBox(

                modifier = Modifier
                    .fillMaxWidth(),
                expanded = expandedForCity,
                onExpandedChange = {
                    expandedForCity = !expandedForCity
                }
            ) {


                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    value = selectedCity,
                    readOnly = false,
                    onValueChange = {
                        selectedCity = it
                        expandedForCity = true
                        warningMessge = ""
                    },
                    maxLines = 1,
                    label = {
                        Text(
                            text = "Укажите город",
                            color = Color.LightGray
                        )
                    },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedForCity)
//                    Icon(imageVector = Icons.Default.ExpandMore, contentDescription ="" )
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        focusedLabelColor = colorResource(id = R.color.navi_orange),
                        focusedBorderColor = colorResource(id = R.color.navi_orange)
                    )
                )

                if (filteringCities.isNotEmpty()) {
                    DropdownMenu(
                        modifier = Modifier
                            .exposedDropdownSize(true),
                        properties = PopupProperties(focusable = false),
                        expanded = expandedForCity,
                        onDismissRequest = { expandedForCity = false },

                        ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            filteringCities.forEach() {
                                it
                                Log.d("Moped", "${filteringCities}")
                                DropdownMenuItem(
                                    text = { Text(text = it.name, fontSize = 14.sp) },
                                    onClick = {
                                        selectedCity = it.name
                                        expandedForCity = false
                                        warningMessge = ""
                                    },
                                    contentPadding = PaddingValues(all = 4.dp)
                                )

                            }
                        }
                    }
                }
            }
        }

        if (warningMessge.isNotEmpty()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Red,
                        shape = RoundedCornerShape(6.dp)
                    )
//                    .background(
//                        color = Color.White,
//                        shape = RoundedCornerShape(6.dp)
//                    )
                    .padding(all = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(24.dp),
                    imageVector = Icons.Default.Error,
                    contentDescription = "error",
                    tint = Color.Red
                )

                Text(
                    text = warningMessge,
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }


        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier
                .width(269.dp)
                .padding(bottom = 24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.navi_orange)),
            onClick = {

                if (name.isEmpty()) {
                    warningMessge = "Введите имя"
                } else if (phone.isEmpty()) {
                    warningMessge = "Введите номер телефона"
                } else if (selectedRegion.isEmpty()) {
                    warningMessge = "Укажите регион"
                } else if (selectedCity.isEmpty()) {
                    warningMessge = "Укажите город"
                } else if (!signInViewModel.regionsFlow.value.contains(selectedRegion)) {
                    warningMessge = "Укажите регион корректно"
                } else if (!signInViewModel.citiesFlow.value.any { it.name == selectedCity }) {
                    warningMessge = "Укажите город корректно"
                } else {

                }

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
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, containerColor = colorResource(
                    id = R.color.dark_backfound
                )
            )
        ) {
            Text(text = "Политика конфиденциальности")
        }

        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, containerColor = colorResource(
                    id = R.color.dark_backfound
                )
            )
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