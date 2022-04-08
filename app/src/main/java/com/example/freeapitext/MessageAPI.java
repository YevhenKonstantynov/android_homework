package com.example.freeapitext;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageAPI {
    @GET("https://api.0x.org/sra/v4/orders?page=3&perPage=4")
    Call<String> message();
}