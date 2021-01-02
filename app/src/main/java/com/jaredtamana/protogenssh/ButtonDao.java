package com.jaredtamana.protogenssh;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

public interface ButtonDao {
    @Query("SELECT * FROM custom_buttons ORDER BY id")
    LiveData<List<CustomButton>> getButtons();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CustomButton button);

    @Query("DELETE FROM custom_buttons")
    void deleteAll();
}
