package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.finalproject.adapters.GameCategoryRecyclerAdapter;
import com.example.finalproject.adapters.StatsRecyclerAdapter;
import com.example.finalproject.model.Categories;
import com.example.finalproject.model.Model;
import com.example.finalproject.model.Stats;
import com.example.finalproject.viewHolders.CategoryStatsViewHolder;

public class MainActivity extends AppCompatActivity {
    StatsRecyclerAdapter mStatsRecyclerAdapter;
    RecyclerView mStatsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Model.getInstance().loadModels();
        Stats stats = Model.getInstance().getStats();
        mStatsRecycler = findViewById(R.id.stats_recycler_view);

        mStatsRecyclerAdapter = new StatsRecyclerAdapter(this, stats);
        mStatsRecycler.setLayoutManager(new LinearLayoutManager(this));
        mStatsRecycler.setAdapter(mStatsRecyclerAdapter);
    }

    public void onClickNewGame(View v){
        Intent intent = new Intent(getApplicationContext(),NewGameActivity.class);
        startActivity(intent);
    }
}