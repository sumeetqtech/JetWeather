package com.compose.weatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.weatherforecast.ui.screens.about.AboutScreen
import com.compose.weatherforecast.ui.screens.main.MainScreen
import com.compose.weatherforecast.ui.screens.main.MainViewModel
import com.compose.weatherforecast.ui.screens.search.SearchScreen
import com.compose.weatherforecast.ui.screens.splash.SplashScreen

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
            val mainViewModel: MainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController, mainViewModel, "Mumbai")
        }
    }
}