package com.jaredtamana.protogenssh;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class CustomButtonRepository {

    private CustomButtonDao mCustomButtonDao;
    private LiveData<List<CustomButton>> mAllCustomButtons;

    // Note that in order to unit test the CustomButtonRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    CustomButtonRepository(Application application) {
        CustomButtonRoomDatabase db = CustomButtonRoomDatabase.getDatabase(application);
        mCustomButtonDao = db.CustomButtonDao();
        mAllCustomButtons = mCustomButtonDao.getCustomButtons();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<CustomButton>> getAllCustomButtons() {
        return mAllCustomButtons;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(CustomButton button) {
        CustomButtonRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCustomButtonDao.insert(button);
        });
    }

//    void delete(int id) {
//        CustomButtonRoomDatabase.databaseWriteExecutor.execute(() -> {
//            mCustomButtonDao.delete(id);
//        });
//    }
}
