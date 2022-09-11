package com.example.finalproject.viewHolders;

import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

public class GameCategoryItemViewHolder extends RecyclerView.ViewHolder{
    public Button playButton;
    public Spinner difficultySpinner;
    public TextView categoryTextView;


    public GameCategoryItemViewHolder(@NonNull View itemView) {
        super(itemView);

        playButton = itemView.findViewById(R.id.button);
        difficultySpinner = itemView.findViewById(R.id.difficulty_spinner);
        categoryTextView = itemView.findViewById(R.id.category_text_view);

    }
}
