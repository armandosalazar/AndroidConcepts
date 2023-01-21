package com.example.androidconcepts.interfaces;

import com.example.androidconcepts.models.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserApi {
    @GET("/users/{id}")
    Call<User> getUserById(@Path("id") int id);
}
