package com.example.finalproject.model;

public class Game {
    Questions mQuestions;



    Stats.StatItem mStatItem;
    public Game(Categories.Category category){
        mStatItem = new Stats.StatItem(category);
    }
    public Questions.Question getQuestion(int i){
        return mQuestions.getQuestions().get(i);
    }


    public Categories.Category getCategory(){
        return mStatItem.mCategory;
    }
    public Stats.StatItem getStatItem() {
        return mStatItem;
    }
}
