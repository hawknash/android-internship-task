package com.example.githubapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Clienth {

    private static Retrofit retrofit;
    private  static Clienth client;
    private static final String BASE_URL = "https://api.github.com/users/";

   /* public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    } */

    private Clienth() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

    }

    public static synchronized Clienth getRetrofitInstance() {
        if (client == null) {
            client = new Clienth();

        }
        return client;

    }

    public Interface getApi(){
        return retrofit.create(Interface.class);
    }

}
