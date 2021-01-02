package com.jaredtamana.protogenssh;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ButtonViewModel extends AndroidViewModel {
    private ButtonRepository mRepo;

    private final LiveData<List<CustomButton>> mAllButtons;

    public ButtonViewModel(Application application) {
        super(application);
        mRepo = new ButtonRepository(application);
        mAllButtons = mRepo.getAllButtons();
    }

    LiveData<List<CustomButton>> getAllButtons() { return mAllButtons; }

    public void insert(CustomButton button) { mRepo.insert(button);}
}