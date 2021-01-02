package com.jaredtamana.protogenssh;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustomButtonDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * FROM CustomButton_table ORDER BY title")
    LiveData<List<CustomButton>> getCustomButtons();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CustomButton button);

    @Query("DELETE FROM CustomButton_table")
    void deleteAll();
}