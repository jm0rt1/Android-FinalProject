package com.example.finalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.model.Categories;
import com.example.finalproject.model.Stats;
import com.example.finalproject.viewHolders.CategoryStatsViewHolder;
import com.example.finalproject.viewHolders.GameCategoryItemViewHolder;

import java.util.ArrayList;

public class StatsRecyclerAdapter extends RecyclerView.Adapter<CategoryStatsViewHolder>{


    Stats mStats;
    Context mC;

    public StatsRecyclerAdapter(Context c, Stats stats){
        mStats = stats;
        mC = c;
    }
    @NonNull
    @Override
    public CategoryStatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.stats_item,parent,false);
        CategoryStatsViewHolder holder = new CategoryStatsViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryStatsViewHolder holder, int position) {
        Stats.StatItem stat =  mStats.getCategoryStats().get(position);
        holder.categoryTextView.setText(stat.getCategory().getmName());
        holder.correctCountTextView.setText("Correct: "+stat.getCorrect() +"/" +stat.getAnswered());
        holder.percentCorrectTextView.setText("Percent: " +stat.getPercentCorrect()+"%");
    }

    @Override
    public int getItemCount() {
        return mStats.getCategoryStats().size();
    }
}
