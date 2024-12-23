package com.compose.weatherforecast.repository

import com.compose.weatherforecast.data.Results
import com.compose.weatherforecast.model.Weather
import com.compose.weatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApi: WeatherApi) {
    suspend fun getWeather(city: String): Results<Weather> {
        val response = try {
            weatherApi.getWeather(query = city)
        } catch (e: Exception) {
            return Results.Error(exception = e)
        }
        return Results.Success(data = response)
    }
}