package com.example.triphelper.fragment.StartFragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.triphelper.R;

import java.util.List;

public class FirstStartFragment extends Fragment implements View.OnClickListener {
    Button nextFragmentBtn;
    String cityName;
    boolean success;
    List<String> cities;
    RadioButton firstStepBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.first_start_fragment, container, false);
        nextFragmentBtn = (Button) rootView.findViewById(R.id.nextFragmentBtn);
        firstStepBtn = (RadioButton) rootView.findViewById(R.id.firstStepBtn);
        firstStepBtn.setOnClickListener(this);
        nextFragmentBtn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nextFragmentBtn:
                OnNextButtonListener listenerNext = (OnNextButtonListener) getActivity();
                listenerNext.onNextSelected(new SecondStartFragment());
                break;
        }
    }

    public interface OnNextButtonListener {
        void onNextSelected(Fragment nextFragment);
    }
}
