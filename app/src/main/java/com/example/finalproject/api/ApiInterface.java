package com.example.finalproject.api;

import com.example.finalproject.model.Categories;
import com.example.finalproject.model.Category;
import com.example.finalproject.model.Questions;
import com.example.finalproject.model.Stats;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ApiInterface {
    public static class Categories{
        public static class URLS{
            public static String ALL_CATEGORIES = "https://opentdb.com/api_category.php";
        }

        public static com.example.finalproject.model.Categories getAllCategories(){
            String json = ApiCommands.downloadJSONUsingHTTPGetRequest(URLS.ALL_CATEGORIES);
            Gson gson = new Gson();
            com.example.finalproject.model.Categories cats = gson.fromJson(json, com.example.finalproject.model.Categories.class);
            return cats;
        }
    }

    public static class Questions{

        public static class Difficulties{
            public static String EASY = "easy";
            public static String MEDIUM = "medium";
            public static String HARD = "hard";

        }
        public static class URLS{
            public static String TEN_QUESTIONS(int category_id, String difficulty){
                return "https://opentdb.com/api.php?amount=10&category=" + category_id + "&difficulty=" + difficulty + "&type=multiple";
            }
        }
        public static com.example.finalproject.model.Questions getTenQuestions(int category_id, String difficulty){

            String json=  ApiCommands.downloadJSONUsingHTTPGetRequest(URLS.TEN_QUESTIONS(category_id, difficulty));
            Gson gson = new Gson();
            com.example.finalproject.model.Questions qs = gson.fromJson(json, com.example.finalproject.model.Questions.class);
            return qs;
        }
    }

}
