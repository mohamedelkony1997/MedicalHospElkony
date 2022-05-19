package com.example.hosp.hosiptal;

import com.example.hosp.hosiptal.models.CreateCall.CreateCallRequest;
import com.example.hosp.hosiptal.models.CreateCall.CreateCallResponse;
import com.example.hosp.hosiptal.models.displaycalls.DataItemDisplayCalls;
import com.example.hosp.hosiptal.models.displaycalls.DisplayCallsRequest;
import com.example.hosp.hosiptal.models.displaycalls.DisplayCallsResponse;
import com.example.hosp.hosiptal.models.login.LoginRequest;
import com.example.hosp.hosiptal.models.login.LoginResponse;
import com.example.hosp.hosiptal.models.register.RegisterRequest;
import com.example.hosp.hosiptal.models.register.RegisterResponse;
import com.example.hosp.hosiptal.models.selectdoctors.SelectDoctorsResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Apis {

    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
    @POST("register")
    Call<RegisterResponse> register(@Body RegisterRequest registerRequest);
    @GET("calls")
    Call <DisplayCallsResponse> displaycalls(@Query("date") String date ,@Header("Authorization" ) String token );
    @POST("calls")
    Call<CreateCallResponse> createcalls(@Body CreateCallRequest createCallRequest,@Header("Authorization" ) String token);
    @GET("doctors")
    Call<SelectDoctorsResponse> selectdoctors(@Query("type") String type,@Header("Authorization")String token);

}
