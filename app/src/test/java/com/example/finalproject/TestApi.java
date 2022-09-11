package com.example.finalproject;
import org.junit.Test;


import static org.junit.Assert.*;


import com.example.finalproject.api.ApiCommands;
import com.example.finalproject.api.ApiInterface;
import com.example.finalproject.model.Categories;
import com.example.finalproject.model.Category;
import com.example.finalproject.model.Questions;

import java.util.ArrayList;


public class TestApi {
    @Test
    public void test_downloadJSONUsingHTTPGetRequest(){
        assertEquals(1,1);
        String expected = "{\"trivia_categories\":[{\"id\":9,\"name\":\"General Knowledge\"},{\"id\":10,\"name\":\"Entertainment: Books\"},{\"id\":11,\"name\":\"Entertainment: Film\"},{\"id\":12,\"name\":\"Entertainment: Music\"},{\"id\":13,\"name\":\"Entertainment: Musicals & Theatres\"},{\"id\":14,\"name\":\"Entertainment: Television\"},{\"id\":15,\"name\":\"Entertainment: Video Games\"},{\"id\":16,\"name\":\"Entertainment: Board Games\"},{\"id\":17,\"name\":\"Science & Nature\"},{\"id\":18,\"name\":\"Science: Computers\"},{\"id\":19,\"name\":\"Science: Mathematics\"},{\"id\":20,\"name\":\"Mythology\"},{\"id\":21,\"name\":\"Sports\"},{\"id\":22,\"name\":\"Geography\"},{\"id\":23,\"name\":\"History\"},{\"id\":24,\"name\":\"Politics\"},{\"id\":25,\"name\":\"Art\"},{\"id\":26,\"name\":\"Celebrities\"},{\"id\":27,\"name\":\"Animals\"},{\"id\":28,\"name\":\"Vehicles\"},{\"id\":29,\"name\":\"Entertainment: Comics\"},{\"id\":30,\"name\":\"Science: Gadgets\"},{\"id\":31,\"name\":\"Entertainment: Japanese Anime & Manga\"},{\"id\":32,\"name\":\"Entertainment: Cartoon & Animations\"}]}";
        String result=  ApiCommands.downloadJSONUsingHTTPGetRequest("https://opentdb.com/api_category.php");
        assertEquals(expected,result);
    }

    @Test
    public void testGetAllCategories(){
        Categories vals = ApiInterface.Categories.getAllCategories();
        assertEquals(vals.getsCategories().get(0).getmId(), 9);
        assertEquals(vals.getsCategories().get(0).getmName(), "General Knowledge");

        assertEquals(vals.getsCategories().get(1).getmId(), 10);
        assertEquals(vals.getsCategories().get(1).getmName(), "Entertainment: Books");


        assertEquals(vals.getsCategories().get(8).getmId(), 17);
        assertEquals(vals.getsCategories().get(8).getmName(), "Science & Nature");

        assertEquals(vals.getsCategories().get(23).getmId(), 32);
        assertEquals(vals.getsCategories().get(23).getmName(), "Entertainment: Cartoon & Animations");
    }

    @Test
    public void testGetTenQuestions(){
        Questions qs = ApiInterface.Questions.getTenQuestions(9, ApiInterface.Questions.Difficulties.EASY);
        assertEquals(qs.getQuestions().size(), 10);

        for (int i =0; i<qs.getQuestions().size(); i++){
            assertEquals("General Knowledge", qs.getQuestions().get(i).getCategory());
        }
    }
}
