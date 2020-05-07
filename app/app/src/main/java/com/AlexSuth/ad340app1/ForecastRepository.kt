package com.AlexSuth.ad340app1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

class ForecastRepository {

    private val _weeklyForecast = MutableLiveData<List<DailyForecast>>()
    val weeklyForecast: LiveData<List<DailyForecast>> = _weeklyForecast

    fun loadForecast(zipcode: String){
        val randomValues = List(10) { Random.nextFloat().rem(100) * 100 }
        val forecastItems = randomValues.map { temp ->
            DailyForecast(temp, getTempDescription(temp))
        }
        _weeklyForecast.setValue(forecastItems)
    }

    private fun getTempDescription(temp: Float) : String {
        return when (temp){
            in Float.MAX_VALUE.rangeTo(0f) -> "Anything below 0 doesn't make sense"
            in 0f.rangeTo(32f) -> "Way too cold"
            in 32f.rangeTo(55f) -> "Pretty chilly"
            in 55f.rangeTo(65f) -> "Lots of clouds"
            in 65f.rangeTo(80f) -> "Warm overcast"
            in 80f.rangeTo(90f) -> "It's HOT"
            in 90f.rangeTo(100f) -> "What is this, Arizona?"
            in 100f.rangeTo(Float.MAX_VALUE) -> "OW! It burns"
            else -> "Does not compute"
        }
    }

}