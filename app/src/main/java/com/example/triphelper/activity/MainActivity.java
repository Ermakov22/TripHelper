package com.example.triphelper.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.triphelper.R;
import com.example.triphelper.fragment.MainFragments.ListOfPlacesFragment;
import com.example.triphelper.handler.FragmentController;
import com.example.triphelper.handler.SystemFunctions;
import com.example.triphelper.mvp.core.FragmentByName;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static FragmentTransaction fragmentTransaction;
    static public int WIDTH, HEIGHT;
    public static final String MY_SETTINGS = "my_settings";
    public static Context context;
    MainActivity mainActivity = this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WIDTH = getWindowManager().getDefaultDisplay().getWidth();
        HEIGHT = getWindowManager().getDefaultDisplay().getHeight();
        //getSupportActionBar().hide();
        fragmentManager = getSupportFragmentManager();
        context = this;
        FragmentController.changeNextFragment(new ListOfPlacesFragment(), FragmentByName.LIST_OF_PLACES_FRAGMENT);
    }

    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() == 0){
            SystemFunctions.exitApllication(mainActivity);
        }else fragmentManager.popBackStack();
    }
}

