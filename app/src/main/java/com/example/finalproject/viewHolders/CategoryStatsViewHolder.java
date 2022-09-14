package com.example.finalproject.viewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.R;

public class CategoryStatsViewHolder extends RecyclerView.ViewHolder{

    public TextView categoryTextView, correctCountTextView, percentCorrectTextView;
    public CategoryStatsViewHolder(@NonNull View itemView) {
        super(itemView);

        categoryTextView = itemView.findViewById(R.id.category_text_view);
        correctCountTextView= itemView.findViewById(R.id.correct_count);
        percentCorrectTextView = itemView.findViewById(R.id.percent_correct);
    }


}
