package com.jaredtamana.protogenssh;

import android.content.Context;
import android.widget.Button;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CustomButton.class}, version = 1, exportSchema = false)
public abstract class ButtonRoomDatabase extends RoomDatabase {

    public abstract ButtonDao buttonDao();

    private static volatile ButtonRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ButtonRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (ButtonRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ButtonRoomDatabase.class, "custom_buttons").build();
                }
            }
        }
        return INSTANCE;
    }
}
