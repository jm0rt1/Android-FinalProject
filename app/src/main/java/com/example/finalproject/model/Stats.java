package com.example.finalproject.model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Stats {

    public static class StatItem {
        Categories.Category mCategory;
        int mAnswered = 0 ;
        int mCorrect = 0 ;
        double mPercentCorrect = 0.0;

        public StatItem(Categories.Category category){
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

        public Categories.Category getCategory() {
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

    public ArrayList<StatItem> getCategoryStats() {
        return mCategoryStats;
    }

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
    public void updateCategoryStat(StatItem item) throws Exception {
        for(int i =0; i<mCategoryStats.size();i++){
            if (mCategoryStats.get(i).mCategory.mId == item.mCategory.mId){
                mCategoryStats.get(i).addResult(item);
                return;
            }
        }
        addCategoryStat(item);
    }
}
