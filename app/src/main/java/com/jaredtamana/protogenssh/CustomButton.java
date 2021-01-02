package com.jaredtamana.protogenssh;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CustomButton_table")
public class CustomButton {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "title")
    private String mCustomButton;

    public CustomButton(@NonNull String CustomButton) {
        this.mCustomButton = CustomButton;
    }

    @NonNull
    public int getId() {
        return this.id;
    }

    @NonNull
    public String getCustomButton() {
        return this.mCustomButton;
    }
}