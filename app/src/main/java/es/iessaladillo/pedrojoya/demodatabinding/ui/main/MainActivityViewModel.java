package es.iessaladillo.pedrojoya.demodatabinding.ui.main;

import android.text.TextUtils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<String> countLiveData = new MutableLiveData<>();
    MutableLiveData<String> nameErrorLiveData = new MutableLiveData<>();
    private int count;

    public MainActivityViewModel() {
        countLiveData.setValue(String.valueOf(count));
        nameErrorLiveData.setValue(null);
    }

    private void incrementCount() {
        count++;
        countLiveData.setValue(String.valueOf(count));
    }

    void greet(String name) {
        incrementCount();
        // TODO: Use a resource string instead of a literal.
        // TODO: The ViewModel will need to receive the Application object so as access resources.
        nameErrorLiveData.setValue(isValidName(name) ? null : "Invalid data");
        // TODO: Use LiveData to greet user with the given name.
    }

    private boolean isValidName(String name) {
        return !TextUtils.isEmpty(name);
    }

}