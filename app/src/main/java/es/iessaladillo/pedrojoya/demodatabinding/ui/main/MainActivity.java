package es.iessaladillo.pedrojoya.demodatabinding.ui.main;

import android.os.Bundle;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.demodatabinding.R;
import es.iessaladillo.pedrojoya.demodatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    // The name of the class will be "NameOfLayoutBinding".
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We inflate the layout with data binding library, getting the binding object in response.
        b = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // We obtain the viewModel (a new instance the first time, the same instance after
        // rotation).
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        // We set the value of the data binding variable vm as the viewModel object.
        b.setVm(viewModel);
        // Don't forget to indicate to the binding object with what lifecycle it has to work
        // with, or it won't be able to observe LiveData objects.
        b.setLifecycleOwner(this);
        setupViews();
        // TODO: Use data binding.
        observeNameValid();
    }

    private void setupViews() {
        // TODO: Use data binding.
        b.btnGreet.setOnClickListener(v -> viewModel.greet(b.txtName.getText().toString()));
        // TODO: Use data binding.
        b.txtName.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                viewModel.greet(b.txtName.getText().toString());
                return true;
            }
            return false;
        });
    }

    // TODO: Use data binding.
    private void observeNameValid() {
        viewModel.nameErrorLiveData.observe(this, errorMessage -> b.txtName.setError(errorMessage));
    }

}
