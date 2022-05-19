package com.example.hosp.hosiptal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetorfitClient {
    private static Retrofit retrofit;

    public static Apis getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl("http://api.instant-ss.com/api/v1/").addConverterFactory(GsonConverterFactory.
                    create()).build();
        }
        return retrofit.create(Apis.class);
    }
}
