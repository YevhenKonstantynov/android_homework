package com.example.freeapitext;

import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private WeatherService weatherService;

    public RemoteDataSource() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }

    public List getWeatherDay(String s) {
        Call<List> call = weatherService.getDayByCityName(s, "3d822b9dce4e57f12b9b3400d480a358");
        try {
            Response<List> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            }
        } catch (IOException ioex) {
            Log.e("Remote", "IOEX: " + ioex.toString());
        }
        return null;
    }


}
