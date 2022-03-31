package com.example.hosp.hosiptal;

import com.example.hosp.hosiptal.models.login.LoginRequest;
import com.example.hosp.hosiptal.models.login.LoginResponse;
import com.example.hosp.hosiptal.models.register.RegisterRequest;
import com.example.hosp.hosiptal.models.register.RegisterResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Apis {
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);




}
