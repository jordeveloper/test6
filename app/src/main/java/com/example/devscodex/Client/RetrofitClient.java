package com.example.devscodex.Client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String baseUrl = "https://api.themoviedb.org/4/list/1?api_key=";
    //https://api.themoviedb.org/4/list/1?api_key=2c46288716a18fb7aadcc2a801f3fc6b
    //"http://api.themoviedb.org/3/" test

    private static Retrofit retrofit = null;

    public static Retrofit getClien()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
