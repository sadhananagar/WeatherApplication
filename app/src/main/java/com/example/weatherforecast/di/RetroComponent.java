package com.example.weatherforecast.di;

import com.example.weatherforecast.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {
    public void inject(MainActivityViewModel mainActivityViewModel);

}
