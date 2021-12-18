package com.example.weatherforecast.di;

import com.example.weatherforecast.model.RecyclerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {

    @GET("forecast")
    Call<RecyclerList> getDataFromAPI(@Query("q")String city_name,
                                      @Query("appid") String apikey);



}
