package com.example.finalproject.model;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

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
    private Stats stats;
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
}
