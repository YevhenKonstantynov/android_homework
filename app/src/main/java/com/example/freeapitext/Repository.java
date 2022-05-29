package com.example.freeapitext;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.concurrent.Executors;

public class Repository {
    private final LocalDataSource localDataSource;
    private final RemoteDataSource remoteDataSource;

    public Repository(Context context) {
        localDataSource = new LocalDataSource(context);
        remoteDataSource = new RemoteDataSource();
    }

    public void storeWeatherForDay(List example) {
        WeatherEntity we = new WeatherEntity();
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.id = 33;
        weatherEntity.temp = example.getMain().getTemp() - 273;
        weatherEntity.dateTime = "now";
        weatherEntity.wind = example.getWind().getSpeed();
        localDataSource.storeWeather(weatherEntity);
    }

    public LiveData<WeatherEntity> getOneDayWeatherData(String s) {// 1 день
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                List weatherForecast = remoteDataSource.getWeatherDay(s);
                storeWeatherForDay(weatherForecast);
            }
        });
        return localDataSource.getWeatherForOneDay();
    }
}
