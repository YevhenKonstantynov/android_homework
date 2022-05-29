package com.example.freeapitext;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class LocalDataSource {
    final WeatherDB db;

    public LocalDataSource(Context context){
        db = Room.databaseBuilder(context, WeatherDB.class,"weather"). fallbackToDestructiveMigration().build();
    }
    public void storeWeather(WeatherEntity we) {
        db.weatherDao().insertWeather(we);
    }

    public LiveData<List<WeatherEntity>> getWeatherForWeek(){
        return db.weatherDao().getWeather();
    }

    public LiveData<WeatherEntity> getWeatherForOneDay(){
        return db.weatherDao().getDayWeather();

    }


}
