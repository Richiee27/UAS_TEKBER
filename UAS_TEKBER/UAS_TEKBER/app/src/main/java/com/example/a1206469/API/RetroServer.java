package com.example.a1206469.API;

import android.icu.number.Scale;

import com.example.a1206469.Adapter.AdapterData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String baseUrl = "http://172.25.160.1/db_brg/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if(retro==null){
//            Gson gson = new GsonBuilder()
//                    .setLenient()
//                    .create();
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            retro = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

        }
        return retro;
    }
}
