package com.compose.weatherforecast.ui.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.compose.weatherforecast.data.Results
import com.compose.weatherforecast.model.Weather
import com.compose.weatherforecast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :
    ViewModel() {

    private val _data: MutableState<Results<Weather>> = mutableStateOf(Results.Loading)
    val data: State<Results<Weather>> get() = _data

    suspend fun getWeatherData(city: String): Results<Weather> {
        return weatherRepository.getWeather(city = city)
    }
}
