package com.example.freeapitext;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CryptoPrice {
    @GET("/swap/v1/price")
    Call<Example> getCryptoPrice(
            @Query("sellToken") String sellToken,
            @Query("buyToken") String buyToken,
            @Query("sellAmount") String sellAmount
    );
}
