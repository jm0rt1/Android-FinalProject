package com.example.finalproject.model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Stats {
    ArrayList<StatItem> mCategoryStats = new ArrayList<>();


    public String toJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public static Stats fromJson(String jsonString){
        Gson gson = new Gson();
        Stats stats = gson.fromJson(jsonString, Stats.class);
        return stats;
    }

    public void addCategoryStat(StatItem item){
        mCategoryStats.add(item);
    }
}
