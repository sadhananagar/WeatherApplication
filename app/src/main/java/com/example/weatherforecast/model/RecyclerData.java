package com.example.weatherforecast.model;

public class RecyclerData {

    private String dt_txt;
    private Main main;


    public RecyclerData(String dt_txt, Main main) {
        this.dt_txt = dt_txt;
        this.main = main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setDt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public String getDt() {
        return dt_txt;
    }

    public Main getMain() {
        return main;
    }
}
