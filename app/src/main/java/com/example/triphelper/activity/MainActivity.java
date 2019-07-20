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

public class MainActivity extends AppCompatActivity implements FirstStartFragment.OnNextButtonListener,
        SecondStartFragment.OnNextButtonListener,
        SecondStartFragment.OnBackButtonListener,
        ThirdStartFragment.OnBackButtonListener {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment currentFragment;
    String CITY;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        currentFragment = new FirstStartFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.main_layout, currentFragment).commit();
    }

    @Override
    public void onNextSelected(String city, boolean success, Fragment nextFragment) {
        if(success){
            CITY = city;
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(currentFragment);
            fragmentTransaction.add(R.id.main_layout, nextFragment);
            fragmentTransaction.commit();
            currentFragment = nextFragment;
        }else Toast.makeText(this, "Город не найден!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onNextSelected(Fragment nextFragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(currentFragment);
        fragmentTransaction.add(R.id.main_layout, nextFragment);
        fragmentTransaction.commit();
        currentFragment = nextFragment;
    }

    @Override
    public void onBackSelected(Fragment backFragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(currentFragment);
        fragmentTransaction.add(R.id.main_layout, backFragment);
        fragmentTransaction.commit();
        currentFragment = backFragment;
    }
}

