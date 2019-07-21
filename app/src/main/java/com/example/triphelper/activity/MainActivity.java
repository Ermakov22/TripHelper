package com.example.triphelper.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.triphelper.R;
import com.example.triphelper.fragment.StartFragments.FirstStartFragment;
import com.example.triphelper.mvp.core.FragmentByName;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    static FragmentManager fragmentManager;
    static FragmentTransaction fragmentTransaction;
    static Context context;
    public static String CITY;
    public static String HOTEl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        context = this;
        fragmentManager = getSupportFragmentManager();
        changeNextFragment(new FirstStartFragment(), FragmentByName.FIRST_START_FRAGMENT);
    }
    public static void changeNextFragment(Fragment fragment, @NotNull FragmentByName fragmentByName){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_layout, fragment);
        fragmentTransaction.addToBackStack(fragmentByName.toString());
        fragmentTransaction.commit();
    }
    public static void makeAnErrorToast(String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
    public static void returnToPreviousFragment(@NotNull FragmentByName fragmentByName){
        fragmentManager.popBackStackImmediate(fragmentByName.toString(), 0);
    }
}

