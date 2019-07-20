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

import java.util.ArrayList;
import java.util.List;

public class SecondStartFragment extends Fragment implements View.OnClickListener {
    Button nextFragmentBtn;
    AutoCompleteTextView city;
    String cityName;
    boolean success;
    List<String> cities;
    RadioButton firstStepBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.second_start_fragment, container, false);
        nextFragmentBtn = (Button) rootView.findViewById(R.id.nextFragmentBtn);
        city =  (AutoCompleteTextView) rootView.findViewById(R.id.cityTxt);
        firstStepBtn = (RadioButton) rootView.findViewById(R.id.firstStepBtn);
        firstStepBtn.setOnClickListener(this);
        nextFragmentBtn.setOnClickListener(this);
        fillListCities();
        uploadAutoTxtViewCities();
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nextFragmentBtn:
                cityName = city.getText().toString();
                if(cityName.length() == 0)
                    success = false;
                else success = true;
                OnNextButtonListener listenerNext = (OnNextButtonListener) getActivity();
                listenerNext.onNextSelected(cityName, success, new ThirdStartFragment());
                break;
            case R.id.firstStepBtn:
                OnBackButtonListener listenerBack = (OnBackButtonListener) getActivity();
                listenerBack.onBackSelected(new FirstStartFragment());
                break;
        }
    }

    public interface OnNextButtonListener {
        void onNextSelected(String city, boolean success, Fragment nextFragment);
    }

    public interface OnBackButtonListener {
        void onBackSelected(Fragment backFragment);
    }

    void fillListCities() {
        cities = new ArrayList<>();
        cities.add("Мадрид");
        cities.add("Махачкала");
        cities.add("Мельбурн");
        cities.add("Манхен");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
        cities.add("Магадан");
    }


    void uploadAutoTxtViewCities() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                cities);
        city.setAdapter(adapter);
    }


}
