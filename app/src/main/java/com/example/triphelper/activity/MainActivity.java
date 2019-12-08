package com.example.triphelper.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
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
import com.example.triphelper.placesAPI.PlaceAutocompleteAPI;
import com.example.triphelper.placesAPI.Reader;
import com.example.triphelper.struct.PlaceInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static Reader reader;
    public static List<List <PlaceInfo> > listOfPlaces;
    public static PlaceAutocompleteAPI.ApiInterface api;
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
        api = PlaceAutocompleteAPI.getClient().create(PlaceAutocompleteAPI.ApiInterface.class);
        //getSupportActionBar().hide();
        reader = new Reader();
        initTest();
        fragmentManager = getSupportFragmentManager();
        context = this;
        FragmentController.changeNextFragment(new ListOfPlacesFragment(), FragmentByName.LIST_OF_PLACES_FRAGMENT);
    }
    void initTest(){
        listOfPlaces = new ArrayList<>();
        listOfPlaces.add(reader.getItems("museums in Rome"));
        listOfPlaces.add(reader.getItems("museums in Rome"));
        listOfPlaces.add(reader.getItems("cafes in Rome"));
        listOfPlaces.add(reader.getItems("shops in Rome"));
        listOfPlaces.add(reader.getItems("supermarkets in Rome"));
    }
    @Override
    public void onBackPressed() {
        if(fragmentManager.getBackStackEntryCount() == 0){
            SystemFunctions.exitApllication(mainActivity);
        }else fragmentManager.popBackStack();
    }
}

