package com.example.finalproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Categories {
    public ArrayList<Category> getsCategories() {
        return mCategories;
    }

    @SerializedName(value = "mCategories", alternate = "trivia_categories")
    ArrayList<Category> mCategories = new ArrayList<>();

    public Category getCategoryByName(String name){
        for (int i=0;i<mCategories.size();i++) {
            if (mCategories.get(i).mName == name) {
                return mCategories.get(i);
            }
        }
        return null;
    }
    public Category getCategoryById(int id){
        for (int i=0;i<mCategories.size();i++) {
            if (mCategories.get(i).mId == id) {
                return mCategories.get(i);
            }
        }
        return null;
    }

}
