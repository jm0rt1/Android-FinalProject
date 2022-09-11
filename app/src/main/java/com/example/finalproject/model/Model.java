package com.example.finalproject.model;

public class Model {
    private static Model instance;
    private boolean isInitialized = false;


    private Categories categories;
    private Stats stats;
    private Questions currentGame;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public void loadModels() {
        if (!isInitialized) {

            isInitialized = true;
        }
    }
}
