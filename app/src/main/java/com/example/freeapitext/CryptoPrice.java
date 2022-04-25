package com.example.freeapitext;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CryptoPrice {
    @GET("/swap/v1/quote")
    Call<Crypto> message(
            @Query("buyToken") String buyToken,
            @Query("sellToken") String sellToken,
            @Query("sellAmount") Integer sellAmount
    );
}
