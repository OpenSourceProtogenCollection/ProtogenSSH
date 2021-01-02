package com.jaredtamana.protogenssh;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CustomButton_table")
public class CustomButton {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String mButtonTitle;

    public CustomButton(@NonNull String buttonTitle) {
        this.mButtonTitle = buttonTitle;
    }

    @NonNull
    public String getButtonTitle() {
        return this.mButtonTitle;
    }
}