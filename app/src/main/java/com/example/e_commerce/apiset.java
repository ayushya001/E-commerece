package com.example.e_commerce;

//import com.example.e_commerce.ResponseModelClass.fetch_response_model;
import com.example.e_commerce.ResponseModelClass.login_response_model;
import com.example.e_commerce.ResponseModelClass.signup_response_model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset {
    @FormUrlEncoded
    @POST("signup")
    Call<signup_response_model> getregister(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobile") String mobile,
            @Field("address") String address
    );
    @FormUrlEncoded
    @POST("login")
    Call<login_response_model> getlogin(
            @Field("email") String email,
            @Field("password") String password
    );

//    @GET("json_user_fetchup")
//    Call<List<fetch_response_model>> getfetch();
}
