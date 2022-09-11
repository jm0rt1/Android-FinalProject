package com.example.finalproject.model;

import com.google.gson.annotations.SerializedName;

public class Category {
    public int getmId() {
        return mId;
    }

    public String getmName() {
        return mName;
    }

    @SerializedName(value = "mId", alternate = "id")
    int mId;
    @SerializedName(value = "mName", alternate = "name")
    String mName;

    public Category(int id, String name){
        mId=id;
        mName = name;
    }

}
