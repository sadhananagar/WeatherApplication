package com.example.weatherforecast.di;

import com.example.weatherforecast.HomePage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetroModule {

    String URL="https://api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}";
    private String baseURL="https://api.github.com/search/";//repositories?q=newyork
    private String API_ID= "36793c466c4f62a833a0673680103397";

    //api.openweathermap.org/data/2.5/forecast?q={city name}&appid={API key}
    //74fa9be197ed33543611c13b51008b9d

    @Provides
    @Singleton
    public RetroServiceInterface getRetroServiceInterface(Retrofit retrofit){
        return retrofit.create(RetroServiceInterface.class);
    }

    @Provides
    @Singleton
    public Retrofit getRetrofitInstance(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
