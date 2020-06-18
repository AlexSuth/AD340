package com.AlexSuth.ad340app1.details

import com.AlexSuth.ad340app1.api.WeatherDescription

data class ForecastDetailsViewState (
    val temp: Float,
    val description: String,
    val date: String,
    val iconUrl: String
)