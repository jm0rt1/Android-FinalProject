package com.example.finalproject.model;

public class StatItem {
    Category mCategory;
    int mAnswered = 0 ;
    int mCorrect = 0 ;
    double mPercentCorrect = 0.0;

    public StatItem(Category category){
        mCategory = category;
    }
    public void addResult(StatItem resultToAdd) throws Exception {
        if (mCategory != resultToAdd.mCategory){
            throw new Exception("cannot add result to differing categories");
        }
        mAnswered += resultToAdd.mAnswered;
        mCorrect += resultToAdd.mCorrect;
        double perc = (double)mCorrect/(double)mAnswered;
        mPercentCorrect = (double)Math.round(perc*10000)/100;

    }

    public Category getCategory() {
        return mCategory;
    }

    public int getAnswered() {
        return mAnswered;
    }

    public int getCorrect() {
        return mCorrect;
    }

    public double getPercentCorrect() {
        return mPercentCorrect;
    }

    public void addAnswered(boolean correct){
        mAnswered ++;
        if (correct){
            mCorrect ++;

        }
        double perc = (double)mCorrect/(double)mAnswered;
        mPercentCorrect = (double)Math.round(perc*10000)/100;
    }


}
