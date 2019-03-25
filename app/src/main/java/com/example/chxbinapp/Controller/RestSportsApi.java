package com.example.chxbinapp.Controller;

import com.example.chxbinapp.Model.RestSports;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestSportsApi {

    @GET("all_sports.php")
    Call<RestSports> getListSports();
}
