package com.jaredtamana.protogenssh;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class CustomButtonListAdapter extends ListAdapter<CustomButton, CustomButtonViewHolder> {

    public CustomButtonListAdapter(@NonNull DiffUtil.ItemCallback<CustomButton> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CustomButtonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CustomButtonViewHolder.create(parent);
    }
    
    @Override
    public void onBindViewHolder(CustomButtonViewHolder holder, int position) {
        CustomButton current = getItem(position);
        holder.bind(current.getButtonTitle());
    }
    
    static class CustomButtonDiff extends DiffUtil.ItemCallback<CustomButton> {
        @Override
        public boolean areItemsTheSame(@NonNull CustomButton oldItem, @NonNull CustomButton newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CustomButton oldItem, @NonNull CustomButton newItem) {
            return oldItem.getButtonTitle().equals(newItem.getButtonTitle());
        }
    }
}
