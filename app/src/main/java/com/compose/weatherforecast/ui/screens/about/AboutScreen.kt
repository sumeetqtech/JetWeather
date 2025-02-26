package com.compose.weatherforecast.ui.screens.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.compose.weatherforecast.R
import com.compose.weatherforecast.ui.components.WeatherTopBar

@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        WeatherTopBar(title = stringResource(R.string.app_name))
    }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) { }
    }
}