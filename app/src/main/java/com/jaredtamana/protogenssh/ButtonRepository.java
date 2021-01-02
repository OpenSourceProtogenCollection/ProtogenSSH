package com.jaredtamana.protogenssh;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class ButtonRepository {

    private ButtonDao mButtonDao;
    private LiveData<List<CustomButton>> mAllButtons;

    ButtonRepository(Application application) {
        ButtonRoomDatabase db = ButtonRoomDatabase.getDatabase(application);
        mButtonDao = db.buttonDao();
        mAllButtons = mButtonDao.getButtons();
    }

    LiveData<List<CustomButton>> getAllButtons() {
        return mAllButtons;
    }

    void insert(final CustomButton button){
        ButtonRoomDatabase.databaseWriteExecutor.execute(() -> {
            mButtonDao.insert(button);
        });
    }
}
