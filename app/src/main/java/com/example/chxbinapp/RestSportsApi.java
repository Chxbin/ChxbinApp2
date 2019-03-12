package com.example.chxbinapp;

import com.example.chxbinapp.Mod.RestSports;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestSportsApi {

    @GET("all_sports.php")
    Call<RestSports> getListSports();
}
