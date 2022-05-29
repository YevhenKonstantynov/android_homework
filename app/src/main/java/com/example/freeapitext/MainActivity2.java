package com.example.freeapitext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    private Repository repository;
    private LiveData<WeatherEntity> weatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String city = (String) getIntent().getExtras().get("city");

        TextView wind = findViewById(R.id.wind);
        TextView temp = findViewById(R.id.temp);

        repository = new Repository(this);
        weatherData = repository.getOneDayWeatherData(city);
        weatherData.observe(this, weatherEntities -> {
            if (weatherData != null) {
                wind.setText("wind: " + String.valueOf(weatherData.getValue().wind));
                temp.setText("temp: " + String.valueOf(weatherData.getValue().temp));
            }
        });


    }
}