package com.example.freeapitext;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //ВАЖНО для нашей задачи
    public void insertWeather(WeatherEntity weatherEntity);

    @Query("SELECT * FROM WeatherEntity")
    public WeatherEntity getWeather();

    @Query("SELECT COUNT(*) FROM WeatherEntity")
    public Integer getCount();

    @Query("SELECT MAX(id) FROM WeatherEntity")
    public Integer getLastId();

}
