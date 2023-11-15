package com.example.navipoint.navigation

sealed class Screens(val route: String) {
    object AuthorizationScreen : Screens(route = "auth_screen")
    object AddProfileScreen : Screens(route = "add_profile")
    object AdminMainScreen : Screens(route = "admin_main")
    object AdminMapScreen : Screens(route = "admin_map")

}