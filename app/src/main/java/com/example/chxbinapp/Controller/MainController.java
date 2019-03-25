package com.example.chxbinapp.Controller;

import android.util.Log;

import com.example.chxbinapp.Model.AllSport;
import com.example.chxbinapp.Model.RestSports;
import com.example.chxbinapp.Model.RestSportsApi;
import com.example.chxbinapp.View.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainController {

    private MainActivity activity;

    private RestSportsApi restSportsApi;

    public MainController(MainActivity mainActivity) {

        this.activity = mainActivity;
    }

    public void onStart() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        restSportsApi = retrofit.create(RestSportsApi.class);




            Call<RestSports> call = restSportsApi.getListSports();
            call.enqueue(new Callback<RestSports>() {
                @Override
                public void onResponse(Call<RestSports> call,
                                       Response<RestSports> response) {
                    RestSports restPlayer = response.body();
                    List<AllSport> listPlayer = restPlayer.getsports();
                    activity.showList(listPlayer);
                }

                @Override
                public void onFailure(Call<RestSports> call, Throwable t) {
                    Log.d("ERROR", "Api Error");
                }
            });
        }


}

