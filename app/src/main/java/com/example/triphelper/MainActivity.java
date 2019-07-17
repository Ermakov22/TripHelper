package com.example.triphelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private final static String MAP_KEY = "AIzaSyDFLZwNZ3j2KNxR6_G4kqL4kO34cUxDZyU";
    private List<LatLng> places = new ArrayList<>();
    @Override
    public void onMapReady(GoogleMap googleMap) {
        MarkerOptions[] markers = new MarkerOptions[places.size()];
        for (int i = 0; i < places.size(); i++) {
            markers[i] = new MarkerOptions()
                    .position(places.get(i));
            googleMap.addMarker(markers[i]);
        }
        //Получаем контекст для запросов, mapsApiKey хранит в себе String с ключом для карт
        GeoApiContext geoApiContext = new GeoApiContext.Builder()
                .apiKey(MAP_KEY)
                .build();

        //(-> (GeoApiContext$Builder .) (.apiKey "blah") .build)
//Здесь будет наш итоговый путь состоящий из набора точек
     /*   DirectionsResult result = null;
        try {
            result = DirectionsApi.newRequest(geoApiContext)
                    .mode(TravelMode.WALKING)
                    .origin(String.valueOf(places.get(0)))//Место старта
                    .destination(String.valueOf(places.get(places.size() - 1)))//Пункт назначения
                  //  .waypoints(String.valueOf(places.get(1)),String.valueOf( places.get(2)))
                    .await();//Промежуточные точки. Да, не очень красиво, можно через цикл, но зато наглядно
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.google.maps.errors.ApiException e) {
            e.printStackTrace();
        }

//Преобразование итогового пути в набор точек
        List<com.google.maps.model.LatLng> path = result.routes[0].overviewPolyline.decodePath();

//Линия которую будем рисовать
        PolylineOptions line = new PolylineOptions();

        LatLngBounds.Builder latLngBuilder = new LatLngBounds.Builder();

//Проходимся по всем точкам, добавляем их в Polyline и в LanLngBounds.Builder
        for (int i = 0; i < path.size(); i++) {
            line.add(new com.google.android.gms.maps.model.LatLng(path.get(i).lat, path.get(i).lng));
            latLngBuilder.include(new com.google.android.gms.maps.model.LatLng(path.get(i).lat, path.get(i).lng));
        }

//Делаем линию более менее симпатичное
        line.width(16f).color(R.color.colorPrimary);

//Добавляем линию на карту
        googleMap.addPolyline(line);
//Выставляем камеру на нужную нам позицию
        LatLngBounds latLngBounds = latLngBuilder.build();
        CameraUpdate track = CameraUpdateFactory.newLatLngBounds(latLngBounds, getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight(), 25);//width это размер нашего экрана
        googleMap.moveCamera(track);*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        places.add(new LatLng(55.754724, 37.621380));
        places.add(new LatLng(55.760133, 37.618697));
        places.add(new LatLng(55.764753, 37.591313));
        places.add(new LatLng(55.728466, 37.604155));

        }

    //private class GeoApiContext$Builder {
    //}
}

