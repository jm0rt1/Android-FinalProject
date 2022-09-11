package com.example.finalproject;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.finalproject.model.Categories.Category;
import com.example.finalproject.model.Model;
import com.example.finalproject.model.Stats;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestModel {

    @Test
    public void test_adding_results() throws Exception {
        Category c = new Category(1, "a category");
        Stats.StatItem item1 = new Stats.StatItem(c);
        Stats.StatItem item2 = new Stats.StatItem(c);
        item1.addResult(item2);

        assertEquals(item1.getAnswered(),0);
        item2.addAnswered(true);
        item2.addAnswered(true);
        item2.addAnswered(true);
        item2.addAnswered(false);

        assertEquals(4,item2.getAnswered());
        assertEquals(3,item2.getCorrect());
        assertEquals(75,item2.getPercentCorrect(),.01);

        item1.addResult(item2);
        assertEquals(4,item1.getAnswered());
        assertEquals(3,item1.getCorrect());
        assertEquals(75,item1.getPercentCorrect(),.01);

    }

    @Test
    public void test_json_stats() throws Exception {
        Category c = new Category(1, "a category");
        Stats.StatItem item1 = new Stats.StatItem(c);

        Stats stats = new Stats();
        stats.addCategoryStat(item1);
        assertEquals("{\"mCategoryStats\":[{\"mCategory\":{\"mId\":1,\"mName\":\"a category\"},\"mAnswered\":0,\"mCorrect\":0,\"mPercentCorrect\":0.0}]}",stats.toJson());
        item1.addAnswered(false);

        assertEquals("{\"mCategoryStats\":[{\"mCategory\":{\"mId\":1,\"mName\":\"a category\"},\"mAnswered\":1,\"mCorrect\":0,\"mPercentCorrect\":0.0}]}",stats.toJson());
        item1.addAnswered(true);

        assertEquals("{\"mCategoryStats\":[{\"mCategory\":{\"mId\":1,\"mName\":\"a category\"},\"mAnswered\":2,\"mCorrect\":1,\"mPercentCorrect\":50.0}]}",stats.toJson());

        Stats stats2 = Stats.fromJson("{\"mCategoryStats\":[{\"mCategory\":{\"mId\":1,\"mName\":\"a category\"},\"mAnswered\":2,\"mCorrect\":1,\"mPercentCorrect\":50.0}]}");
        assertEquals("{\"mCategoryStats\":[{\"mCategory\":{\"mId\":1,\"mName\":\"a category\"},\"mAnswered\":2,\"mCorrect\":1,\"mPercentCorrect\":50.0}]}",stats2.toJson());


    }


}