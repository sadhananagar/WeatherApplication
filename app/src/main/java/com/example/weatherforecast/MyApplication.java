package com.example.weatherforecast;

import android.app.Application;

import com.example.weatherforecast.di.DaggerRetroComponent;
import com.example.weatherforecast.di.RetroComponent;
import com.example.weatherforecast.di.RetroModule;

public class MyApplication extends Application {

    private RetroComponent retroComponent;

    @Override
    public void onCreate() {
        super.onCreate ();

        retroComponent = DaggerRetroComponent.builder()
                .retroModule(new RetroModule())
                .build();
    }

    public  RetroComponent getRetroComponent(){
        return  retroComponent;
    }
}
