package com.example.freeapitext;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.freeapitext.databinding.ActivityMain2Binding;

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

        String currency = (String) getIntent().getExtras().get("currency");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.0x.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CryptoPrice cryptoPrice;
        cryptoPrice = retrofit.create(CryptoPrice.class);
        cryptoPrice.getCryptoPrice(currency, "TUSD", "1000").
                enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        if (response.isSuccessful()) {
                            final TextView priceElem = findViewById(R.id.price);
                            final TextView buyTokenAddressElem = findViewById(R.id.buyTokenAddress);

                            priceElem.setText("Цена в долларах: " + response.body().getPrice());
                            buyTokenAddressElem.setText("Адрес покупки токена: " + response.body().getBuyTokenAddress());
                        } else Log.i("crypto", "no response");
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Log.i("crypto", "Failure " + t);
                    }
                });

    }
}