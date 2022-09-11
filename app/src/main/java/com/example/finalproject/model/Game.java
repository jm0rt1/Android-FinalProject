package com.example.finalproject.model;

public class Game {
    Questions mQuestions;
    Stats.StatItem mStatItem;
    public Game(Categories.Category category){
        mStatItem = new Stats.StatItem(category);
    }

    public Categories.Category getCategory(){
        return mStatItem.mCategory;
    }

}
