package com.example.weatherforecast.model;

public class Main {
    private String temp_min, temp_max;

    public Main(String temp_min, String temp_max) {

        this.temp_min = temp_min;
        this.temp_max= temp_max;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_min() {
        return temp_min;
    }



}
