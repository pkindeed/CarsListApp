package com.example.carslistapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.content.Context.LOCATION_SERVICE;
import static android.util.Log.wtf;


public class ListFragment extends Fragment implements View.OnClickListener {

    public CustomAdapter adapter;
    LocationManager mLocationManager;
    android.location.Location location;


    public ListFragment (){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        final RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
                    } else {
                        // Oups permission denied
                    }
                });
        carsView(getActivity().findViewById(R.id.list_view));

        Button button = (Button) getActivity().findViewById(R.id.button);
        if (button != null){
            button.setOnClickListener(this);
        }

        super.onActivityCreated(savedInstanceState);
    }



    public void sortCars(View view,  android.location.Location location){
        adapter.sort(new Comparator<Car>() {
            @SuppressLint("MissingPermission")
            @Override
            public int compare(Car o1, Car o2) {
                    double ln = location.getLongitude();
                    double lat = location.getLatitude();
                    double a = (FlatEarthDist.distance(lat, o1.getLocation().getLatitude(), ln,
                            o1.getLocation().getLongitude()));
                    double b = (FlatEarthDist.distance(lat, o2.getLocation().getLatitude(), ln,
                            o2.getLocation().getLongitude()));

                    if (b < a) {
                        return (-1);
                    } else if (b > a) {
                        return (1);
                    }
            return (0);
            }
        });
    }

    public void carsView(View view){
        Ion.with(this).load("https://development.espark.lt/api/mobile/public/availablecars")
                .asString()
                .setCallback(new FutureCallback<String>(){
                    @Override
                    public void onCompleted(Exception e, String data) {
                        if (data != null) {
                            processCarData(data);

                        }else{
                        }
                    }
                });
    }

    private void processCarData(String data) {
        ///Process for list
        try {
            ArrayList arrayList = new ArrayList<>();
            ListView lv = (ListView) getActivity().findViewById(R.id.list_view);
            Gson gson = new Gson();
            Car carObjects[] = gson.fromJson(data, Car[].class);

            for (int i = 0; i < carObjects.length; i++) {
                arrayList.add(new Car(
                        carObjects[i].getModel(),
                        carObjects[i].getLocation(),
                        carObjects[i].getPlateNumber(),
                        carObjects[i].getBatteryPercentage()));
            }

            adapter = new CustomAdapter(
                    getActivity().getApplicationContext(), R.layout.list_view_items, arrayList
            );

            if (lv != null) {
                lv.setAdapter(adapter);

            }

            EditText filterPlate = (EditText) getActivity().findViewById(R.id.filterPlate);
            if (filterPlate != null) {
                filterPlate.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        (ListFragment.this).adapter.getFilter("plateFilter").filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });

                EditText batteryLeft = (EditText) getActivity().findViewById(R.id.batteryLeft);
                batteryLeft.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        (ListFragment.this).adapter.getFilter("batteryFilter").filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }
                });
            }
        } catch (JsonParseException e) {
            wtf("error", e);
        }
    }
    @SuppressLint("MissingPermission")
    private void checkLocation() {

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(false);
        criteria.setHorizontalAccuracy(Criteria.ACCURACY_HIGH);
        criteria.setVerticalAccuracy(Criteria.ACCURACY_HIGH);

        mLocationManager = (LocationManager) getActivity().getApplicationContext().getSystemService(LOCATION_SERVICE);
        mLocationManager.requestSingleUpdate(criteria, mLocationListener, null);
        location = mLocationManager.getLastKnownLocation(LOCATION_SERVICE);
        if (location == null){
            TextView textView = (TextView) getActivity().findViewById(R.id.textView);
            if (textView != null) {
                textView.setText("Waiting for gps data ...");
            }
        }

    }

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(android.location.Location location) {
            if (location != null) {
                TextView textView = (TextView) getActivity().findViewById(R.id.textView);
                ListView listView = (ListView) getActivity().findViewById(R.id.list_view);

                if (textView != null) {
                    textView.setText("" +
                            "Sorted by your GPS location!");

                }
                if (listView != null) {
                    sortCars(listView, location);
                }
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }

    };

    @Override
    public void onClick(View v) {
        checkLocation();
    }
}
