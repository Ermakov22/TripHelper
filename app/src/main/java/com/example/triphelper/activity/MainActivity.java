package com.example.triphelper.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.triphelper.R;
import com.example.triphelper.fragment.StartFragments.FirstStartFragment;
import com.example.triphelper.fragment.StartFragments.SecondStartFragment;
import com.example.triphelper.fragment.StartFragments.ThirdStartFragment;
import com.example.triphelper.mvp.core.FragmentById;

public class MainActivity extends AppCompatActivity implements FirstStartFragment.OnNextButtonListener,
        SecondStartFragment.OnNextButtonListener,
        SecondStartFragment.OnBackButtonListener,
        ThirdStartFragment.OnNextButtonListener,
        ThirdStartFragment.OnBackButtonListener {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment currentFragment;
    String CITY;
    FragmentById currentFragmentId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        currentFragment = new FirstStartFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_layout, currentFragment).commit();
        currentFragmentId = FragmentById.FIRST_START_FRAGMENT;
    }

    @Override
    public void onNextSelected(String city, boolean success, Fragment nextFragment,  FragmentById fragmentId ) {
        if(success){
            CITY = city;
            changeFragmentTo(nextFragment);
            currentFragmentId = fragmentId;
        }else Toast.makeText(this, "Город не найден!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNextSelected(Fragment nextFragment, FragmentById fragmentId) {
        changeFragmentTo(nextFragment);
        currentFragmentId = fragmentId;
    }

    @Override
    public void onBackSelected(Fragment backFragment,  FragmentById fragmentId) {
        changeFragmentTo(backFragment);
        currentFragmentId = fragmentId;
    }

    private void changeFragmentTo(Fragment fragment){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(currentFragment);
        fragmentTransaction.add(R.id.main_layout, fragment);
        fragmentTransaction.commit();
        currentFragment = fragment;
    }

    @Override
    public void onBackPressed() {
        switch (currentFragmentId){
            case FIRST_START_FRAGMENT:
                break;
            case SECOND_START_FRAGMENT:
                changeFragmentTo(new FirstStartFragment());
                currentFragmentId = FragmentById.FIRST_START_FRAGMENT;
                break;
            case THIRD_START_FRAGMENT:
                changeFragmentTo(new SecondStartFragment());
                currentFragmentId = FragmentById.SECOND_START_FRAGMENT;
                break;
            case LIST_OF_PLACES_FRAGMENT:
                changeFragmentTo(new ThirdStartFragment());
                currentFragmentId = FragmentById.THIRD_START_FRAGMENT;
                break;
        }
    }
}

