package com.jaredtamana.protogenssh;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CustomButton.class}, version = 1, exportSchema = false)
public abstract class CustomButtonRoomDatabase extends RoomDatabase {

    public abstract CustomButtonDao CustomButtonDao();

    private static volatile CustomButtonRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CustomButtonRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CustomButtonRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CustomButtonRoomDatabase.class, "CustomButton_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
