package com.example.freeapitext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String city = (String) getIntent().getExtras().get("city");

        WeatherDB database = Room.databaseBuilder(getApplicationContext(), WeatherDB.class, "weather")
                .fallbackToDestructiveMigration()
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherWeekService weather;
        weather = retrofit.create(WeatherWeekService.class);
        weather.message(city, "3d822b9dce4e57f12b9b3400d480a358").
                enqueue(new Callback<WeekWeather>() {
                    @Override
                    public void onResponse(Call<WeekWeather> call, Response<WeekWeather> response) {
                        if (response.isSuccessful()) {
                            Executors.newSingleThreadExecutor().execute(() -> {
                                int id = database.weatherDao().getLastId();
                                for (List entity : response.body().getList()) {
                                    WeatherEntity weatherEntity = new WeatherEntity();

                                    weatherEntity.id = id++;
                                    weatherEntity.temp = entity.getMain().getTemp() - 273;
                                    weatherEntity.dateTime = entity.getDtTxt();
                                    weatherEntity.wind = entity.getWind().getSpeed();

                                    database.weatherDao().insertWeather(weatherEntity);
                                }

                                Log.i("weather count", database.weatherDao().getCount().toString());
                            });
                        } else Log.i("weather", "no response");
                    }

                    @Override
                    public void onFailure(Call<WeekWeather> call, Throwable t) {
                        Log.i("weather", "Failure " + t);
                    }
                });
    }
}