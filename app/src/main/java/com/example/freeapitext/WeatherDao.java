package com.example.freeapitext;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //ВАЖНО для нашей задачи
    public void insertWeather(WeatherEntity weatherEntity);

    @Query("SELECT * FROM WeatherEntity")
    public LiveData<List<WeatherEntity>> getWeather();

    @Query("SELECT * FROM WeatherEntity LIMIT 1")
    public LiveData<WeatherEntity> getDayWeather();

    @Query("SELECT COUNT(*) FROM WeatherEntity")
    public Integer getCount();

    @Query("SELECT MAX(id) FROM WeatherEntity")
    public Integer getLastId();

}
