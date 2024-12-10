package com.compose.weatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.weatherforecast.screens.about.AboutScreen
import com.compose.weatherforecast.screens.main.MainScreen
import com.compose.weatherforecast.screens.search.SearchScreen
import com.compose.weatherforecast.screens.splash.SplashScreen

@Preview
@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WeatherScreens.SplashScreen.name
    ) {
        composable(route = WeatherScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(route = WeatherScreens.AboutScreen.name) {
            AboutScreen(navController = navController)
        }
        composable(route = WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
        composable(route = WeatherScreens.MainScreen.name) {
            MainScreen(navController = navController)
        }
    }
}