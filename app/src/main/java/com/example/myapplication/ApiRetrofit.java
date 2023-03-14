package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiRetrofit {
    @POST("user/login")
    Call<User_Mask> createUser(@Body User_Model userModel);
}
