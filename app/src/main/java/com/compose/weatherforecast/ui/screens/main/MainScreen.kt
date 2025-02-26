package com.compose.weatherforecast.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.compose.weatherforecast.data.Results
import com.compose.weatherforecast.model.Weather
import com.compose.weatherforecast.ui.components.WeatherTopBar

@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
    city: String
) {
    Scaffold(topBar = {
        WeatherTopBar(title = city)
    }) { innerPadding ->
        ShowData(
            mainViewModel, innerPadding, city
        )
    }
}

@Composable
fun ShowData(mainViewModel: MainViewModel, innerPadding: PaddingValues, city: String) {

    val weatherData = produceState<Results<Weather>>(initialValue = Results.Loading) {
        value = mainViewModel.getWeatherData(city)
    }.value

    when (weatherData) {
        is Results.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }

        is Results.Success -> {
            MainContent(
                modifier = Modifier.padding(innerPadding),
                weatherData.data
            )
        }

        is Results.Error -> {
            Text(
                modifier = Modifier.padding(innerPadding),
                text = "Error: ${weatherData.exception.message}"
            )
        }
    }
}

@Composable
fun MainContent(modifier: Modifier, weather: Weather) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = weather.city.country)
    }
}


