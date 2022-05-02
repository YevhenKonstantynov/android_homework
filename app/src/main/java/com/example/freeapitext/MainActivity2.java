package com.example.freeapitext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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
                            MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(getApplicationContext(), response.body().getList());
                            recyclerView.setAdapter(adapter);
                        } else Log.i("weather", "no response");
                    }

                    @Override
                    public void onFailure(Call<WeekWeather> call, Throwable t) {
                        Log.i("weather", "Failure " + t);
                    }
                });
    }
}