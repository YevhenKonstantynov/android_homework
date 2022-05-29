package com.example.freeapitext;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("/data/2.5/forecast")
    Call<WeekWeather> getWeekByCityName(
            @Query("q") String city,
            @Query("appid") String appid
    );

    @GET("/data/2.5/weather")
    Call<List> getDayByCityName(
            @Query("q") String city,
            @Query("appid") String appid
    );
}
