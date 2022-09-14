package com.example.finalproject.viewHolders;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.CurrentGameActivity;
import com.example.finalproject.R;
import com.example.finalproject.model.Categories;
import com.example.finalproject.model.Model;

public class GameCategoryItemViewHolder extends RecyclerView.ViewHolder{
    public Button playButton;
    public Spinner difficultySpinner;
    public TextView categoryTextView;
    public Categories.Category category;

    public GameCategoryItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.getContext();
        playButton = itemView.findViewById(R.id.button);
        difficultySpinner = itemView.findViewById(R.id.difficulty_spinner);
        categoryTextView = itemView.findViewById(R.id.category_text_view);
        playButton.setOnClickListener(this::clickPlay);

    }

    public void clickPlay(View v){
        Model.getInstance().newGame(category,difficultySpinner.getSelectedItem().toString(), v);
    }
}
