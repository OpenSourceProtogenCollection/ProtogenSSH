package com.jaredtamana.protogenssh;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CustomButtonViewModel extends AndroidViewModel {

    private CustomButtonRepository mRepository;

    private final LiveData<List<CustomButton>> mAllCustomButtons;

    public CustomButtonViewModel (Application application) {
        super(application);
        mRepository = new CustomButtonRepository(application);
        mAllCustomButtons = mRepository.getAllCustomButtons();
    }

    LiveData<List<CustomButton>> getAllCustomButtons() { return mAllCustomButtons; }

    public void insert(CustomButton button) { mRepository.insert(button); }
}
