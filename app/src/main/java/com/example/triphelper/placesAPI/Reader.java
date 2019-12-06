package com.example.triphelper.placesAPI;

import android.util.Log;

import com.example.triphelper.R;
import com.example.triphelper.struct.ShortDescription;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.triphelper.activity.MainActivity.api;

public class Reader {

    String TAG = "PLACE";
    public List<ShortDescription> getItems(String input) {
        List<ShortDescription> resultList = new ArrayList<>();
        String key = PlaceAutocompleteAPI.KEY;
        Log.d(TAG, input); /* show url */
        Call<PlaceSerializer> callPlaces = api.getPredictions(key, input);
        Log.d(TAG, callPlaces.request().url().toString()); /* show url */
        try {
            callPlaces.enqueue(new Callback<PlaceSerializer>() {
                @Override
                public void onResponse(Call<PlaceSerializer> call, Response<PlaceSerializer> response) {
                    List<PlaceSerializer.Place> places;
                    PlaceSerializer predictions = response.body();
                    places = predictions.getPlaces();
                    Log.d(TAG, "Succesful");
                    if (!places.isEmpty()) {
                        for (PlaceSerializer.Place place : places) {
                            resultList.add(detailInformation(place.getPlaceID()));
                        }
                    }
                    else    Log.d(TAG, "EMPTY!!!");
                }
                @Override
                public void onFailure(Call<PlaceSerializer> call, Throwable t) {
                    Log.d(TAG, "Connected failed");
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error connecting to Places API", e);
            return resultList;
        }
        Log.d(TAG, resultList.size() + " = resultList size");
        return resultList;
    }
    ShortDescription detailInformation(String placeID){
        ShortDescription currPoint = new ShortDescription("roflanENtin", "2", "3", false);;
        String key = PlaceAutocompleteAPI.KEY;
        Call<PlaceDetailSerializer> callPlaces = api.getPlace(key, placeID);
        Log.d(TAG, callPlaces.request().url().toString()); /* show url */
        try {
            callPlaces.enqueue(new Callback<PlaceDetailSerializer>() {
                @Override
                public void onResponse(Call<PlaceDetailSerializer> call, Response<PlaceDetailSerializer> response) {
                    PlaceDetailSerializer predictions = response.body();
                    PlaceDetailSerializer.Place currPlace = predictions.getPlace();
                    Log.d(TAG, "Succesful");
                    Log.d(TAG, currPlace.toString());
                    //String name = currPlace.getName();
                    //String description = currPlac
                    currPoint.setName(currPlace.getName());
                    currPoint.setImageId(currPlace.getPhotoURL(500));
                    if(currPoint.getImageId() == null) currPoint.setImageId("https://starpri.ru/wp-content/uploads/2019/02/mX2YdEeLJUo.jpg");
                }
                @Override
                public void onFailure(Call<PlaceDetailSerializer> call, Throwable t) {
                    Log.d(TAG, "Connected failed");
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error connecting to Places API", e);
        }
        return currPoint;
    }
}

