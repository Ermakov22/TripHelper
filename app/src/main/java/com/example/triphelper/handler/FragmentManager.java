package com.example.triphelper.handler;

import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.triphelper.R;
import com.example.triphelper.activity.MainActivity;
import com.example.triphelper.mvp.core.FragmentByName;

import org.jetbrains.annotations.NotNull;

public class FragmentManager {
    public static void changeNextFragment(Fragment fragment, @NotNull FragmentByName fragmentByName){
        MainActivity.fragmentTransaction = MainActivity.fragmentManager.beginTransaction();
        MainActivity.fragmentTransaction.replace(R.id.main_layout, fragment);
        MainActivity.fragmentTransaction.addToBackStack(fragmentByName.toString());
        MainActivity.fragmentTransaction.commit();
    }
    public static void makeAnErrorToast(String text){
        Toast.makeText(MainActivity.context, text, Toast.LENGTH_SHORT).show();
    }
    public static void returnToPreviousFragment(@NotNull FragmentByName fragmentByName){
        MainActivity.fragmentManager.popBackStackImmediate(fragmentByName.toString(), 0);
    }
}
