package com.example.finalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;
import com.example.finalproject.model.Categories;
import com.example.finalproject.viewHolders.GameCategoryItemViewHolder;

import java.util.ArrayList;

public class GameCategoryRecyclerAdapter extends RecyclerView.Adapter<GameCategoryItemViewHolder>{


    Categories mCategories;
    Context mC;

    public GameCategoryRecyclerAdapter(Context c, Categories categories){
        mCategories = categories;
        mC = c;
    }
    @NonNull
    @Override
    public GameCategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.game_category_item,parent,false);
        GameCategoryItemViewHolder holder = new GameCategoryItemViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GameCategoryItemViewHolder holder, int position) {

        ArrayList<String> spinnerArray = new ArrayList();
        spinnerArray.add("easy");
        spinnerArray.add("medium");
        spinnerArray.add("hard");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                mC, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.difficultySpinner.setAdapter(adapter);

        holder.categoryTextView.setText(mCategories.getsCategories().get(position).getmName());

    }

    @Override
    public int getItemCount() {
        return mCategories.getsCategories().size();
    }
}
