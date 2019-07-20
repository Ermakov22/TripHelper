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

public class ThirdStartFragment extends Fragment implements View.OnClickListener {
    Button next;
    AutoCompleteTextView city;
    String cityName;
    boolean success;
    List<String> cities;
    RadioButton firstStepBtn, secondStepBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =
                inflater.inflate(R.layout.third_start_fragment, container, false);
        next = (Button) rootView.findViewById(R.id.nextFragmentBtn);
        city =  (AutoCompleteTextView) rootView.findViewById(R.id.cityTxt);
        firstStepBtn = (RadioButton) rootView.findViewById(R.id.firstStepBtn);
        secondStepBtn = (RadioButton) rootView.findViewById(R.id.secondStepBtn);
        firstStepBtn.setOnClickListener(this);
        secondStepBtn.setOnClickListener(this);
        next.setOnClickListener(this);
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
                ThirdStartFragment.OnNextButtonListener listener = (ThirdStartFragment.OnNextButtonListener) getActivity();
                listener.onNextSelected(cityName, success, new ThirdStartFragment());
                break;
            case R.id.firstStepBtn:
                ThirdStartFragment.OnBackButtonListener listenerBackFirst = (ThirdStartFragment.OnBackButtonListener) getActivity();
                listenerBackFirst.onBackSelected(new FirstStartFragment());
                break;
            case R.id.secondStepBtn:
                ThirdStartFragment.OnBackButtonListener listenerBackSecond = (ThirdStartFragment.OnBackButtonListener) getActivity();
                listenerBackSecond.onBackSelected(new SecondStartFragment());
                break;
        }
    }

    public interface OnNextButtonListener {
        void onNextSelected(String city, boolean success, Fragment currentFragment);
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
