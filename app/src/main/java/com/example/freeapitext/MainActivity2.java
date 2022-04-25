package com.example.freeapitext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

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

        String currency = (String) getIntent().getExtras().get("currency");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.0x.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CryptoPrice cryptoPrice;
        cryptoPrice = retrofit.create(CryptoPrice.class);
        cryptoPrice.message( "TUSD", currency, 10000000).
                enqueue(new Callback<Crypto>() {
                    @Override
                    public void onResponse(Call<Crypto> call, Response<Crypto> response) {
                        if (response.isSuccessful()) {
                            MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(getApplicationContext(), response.body().getSources());
                            recyclerView.setAdapter(adapter);

                            EditText priceElem = findViewById(R.id.price);
                            priceElem.setText("Price: " + response.body().getPrice());
                        } else Log.i("crypto", "no response");
                    }

                    @Override
                    public void onFailure(Call<Crypto> call, Throwable t) {
                        Log.i("crypto", "Failure " + t);
                    }
                });
    }
}