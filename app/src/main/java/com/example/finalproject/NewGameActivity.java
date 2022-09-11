package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

import com.example.finalproject.adapters.GameCategoryRecyclerAdapter;
import com.example.finalproject.api.ApiInterface;
import com.example.finalproject.model.Categories;
import com.example.finalproject.model.Model;

public class NewGameActivity extends AppCompatActivity {
    GameCategoryRecyclerAdapter mCategoryAdapter;
    RecyclerView mCategoryRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        mCategoryRecycler = findViewById(R.id.category_recycler);

        Categories cats = Model.getInstance().getAllCategories();
        mCategoryAdapter = new GameCategoryRecyclerAdapter(this, cats);
        mCategoryRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mCategoryRecycler.setAdapter(mCategoryAdapter);
        mCategoryRecycler.scrollToPosition(0);
        PagerSnapHelper helper = new PagerSnapHelper();
        helper.attachToRecyclerView(mCategoryRecycler);
    }
}