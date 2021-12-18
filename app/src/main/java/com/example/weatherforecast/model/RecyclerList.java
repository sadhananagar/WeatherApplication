package com.example.weatherforecast.model;

import java.util.ArrayList;

public class RecyclerList {

    private ArrayList<RecyclerData> list;

    public ArrayList<RecyclerData> getItems() {
        return list;
    }

    public void setItems(ArrayList<RecyclerData> list) {
        this.list = list;
    }

    public RecyclerList(ArrayList<RecyclerData> list) {
        this.list = list;
    }

}
