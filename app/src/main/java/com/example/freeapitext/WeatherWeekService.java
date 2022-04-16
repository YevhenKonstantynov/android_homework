package com.example.freeapitext;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherWeekService {
    @GET("/data/2.5/forecast")
    Call<WeekWeather> message(
            @Query("q") String city,
            @Query("appid") String appid
    );
}
