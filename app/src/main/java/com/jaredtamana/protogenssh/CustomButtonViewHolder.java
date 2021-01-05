package com.jaredtamana.protogenssh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class CustomButtonViewHolder extends RecyclerView.ViewHolder {
    private final TextView CustomButtonItemView;

    private CustomButtonViewHolder(View itemView) {
        super(itemView);
        CustomButtonItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        CustomButtonItemView.setText(text);
    }

    static CustomButtonViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_home, parent, false);
        return new CustomButtonViewHolder(view);
    }
}

