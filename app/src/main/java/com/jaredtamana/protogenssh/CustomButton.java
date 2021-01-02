package com.jaredtamana.protogenssh;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "custom_buttons")
public class CustomButton {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
    public int butId;

    @NonNull
    @ColumnInfo(name="title")
    public String buttonTitle;
}
