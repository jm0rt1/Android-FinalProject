package com.example.finalproject.model;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.example.finalproject.CurrentGameActivity;
import com.example.finalproject.api.ApiInterface;

import java.lang.ref.WeakReference;

public class Model {
    public static String TAG= "Model";
    private static Model instance;
    private boolean isInitialized = false;


    public Categories getAllCategories() {
        return allCategories;
    }

    private Categories allCategories;



    private Stats stats = Stats.load();

    public Game getCurrentGame() {
        return currentGame;
    }

    private Game currentGame;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public void loadModels() {
        if (!isInitialized) {
            new DownloadData(this).execute();
            isInitialized = true;
        }
    }
    public void newGame(Categories.Category category, String difficulty, View v){
        SetupNewGame sng = new SetupNewGame(this,category, difficulty, v);
        sng.execute();

    }
    public Stats getStats() {
        return stats;
    }


    final static class DownloadData extends AsyncTask<Void, Integer, Categories> {

        private final WeakReference<Model> parentRef;


        public DownloadData(final Model parent) {
            parentRef = new WeakReference<Model>(parent);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected Categories doInBackground(Void... voids) {
            try {
                return ApiInterface.Categories.getAllCategories();

            } catch (Exception e) {
                //Log.e(TAG,e.toString());
                return null;
            }
        }

        @Override
        protected void onPostExecute(Categories result) {
            if (result != null){
                parentRef.get().allCategories = result;
            }
        }
    }

    final static class SetupNewGame extends AsyncTask<Void, Integer, Questions> {

        private final WeakReference<Model> parentRef;
        private final Categories.Category mCategory;
        private final String mDifficulty;
        private final WeakReference<View> v;


        public SetupNewGame(final Model parent, Categories.Category category, String difficulty, View view) {

            parentRef = new WeakReference<Model>(parent);
            v = new WeakReference<View>(view);
            mCategory = category;
            mDifficulty = difficulty;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected Questions doInBackground(Void... voids) {
            try {
                return ApiInterface.Questions.getTenQuestions(mCategory.getmId(), mDifficulty);

            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(Questions result) {
            if (result != null){
                parentRef.get().currentGame = new Game(mCategory);
                parentRef.get().currentGame.mQuestions = result;
                Intent intent = new Intent(v.get().getContext(), CurrentGameActivity.class);
                v.get().getContext().startActivity(intent);

            }
        }
    }

}
