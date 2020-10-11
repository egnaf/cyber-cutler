package io.github.egnaf.cybercutler.ui.focus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FocusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FocusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Загружаем фото");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
