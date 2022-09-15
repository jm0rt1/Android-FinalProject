package com.example.finalproject.model;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Stats {
    public final static String STATS_FILE_NAME = "stats.json";
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


    public void save(Context context)
    {
        try {
            final File dir = new File(context.getFilesDir(),  "folderName" );
            if (!dir.exists())
            {
                Boolean result = null;
                try{
                    result = dir.mkdirs();
                    Log.i("save", result.toString());


                } catch (Exception e){
                    Log.e("save", e.toString());

                }


            }

            final File myFile = new File(dir, STATS_FILE_NAME);
            if (!myFile.exists())
                myFile.createNewFile();

            FileWriter writer = new FileWriter(myFile);
            String jsonString = toJson();
            try{
                writer.write(jsonString);

            } catch (Exception e){
                Log.e("writing to file",e.toString());
            }

            writer.close();

        } catch (IOException e) {
            Log.e("writing to file",e.toString());
        }
    }

    public static Stats load(Context context)
    {
        final File dir = new File(context.getFilesDir(),  "folderName" );
        String jsonString;
        if (!dir.exists())
        {
            if(!dir.mkdirs()){
                Log.e("read file","Failed to create the directories");
            }
        }

        final File myFile = new File(dir, STATS_FILE_NAME);

        try{
            FileInputStream stream = new FileInputStream(myFile);
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            jsonString = new String(buffer, "UTF-8");
            return fromJson(jsonString);
        }catch (Exception e){
            Log.e("writing file",e.toString());
        }
        return new Stats();
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
