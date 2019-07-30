package com.example.carslistapp;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Car> implements Filterable {

    ArrayList<Car> cars;
    ArrayList<Car> originalCars;
    Context context;
    int resourse;

    public CustomAdapter(Context context, int resource, ArrayList<Car> cars) {
        super(context, resource, cars);
        this.cars = cars;
        this.context = context;
        this.resourse = resource;
        originalCars = new ArrayList<>(cars);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_view_items, null, true);
        }

        Car car = getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        Picasso.with(context).load(car.getModel().getPhotoUrl()).into(imageView);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(car.getModel().getTitle());

        TextView battery = (TextView) convertView.findViewById(R.id.battery);
        battery.setText("Battery left: " + car.getBatteryPercentage().toString()+ "%");

        TextView plateNumber = (TextView) convertView.findViewById(R.id.plateNumber);
        plateNumber.setText("Plate number: "+car.getPlateNumber());

        TextView gatve = (TextView) convertView.findViewById(R.id.gatve);
        gatve.setText("Current adress: "+car.getLocation().getAddress());

        return convertView;
    }


    ///Filter part.



    public Filter getFilter(String a) {
      if (a == "plateFilter"){
          return plateFilter;
      }else if (a == "batteryFilter") {
          return batteryFilter;
      }
      return null;
    }


        private Filter plateFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                // Create a FilterResults object
                FilterResults results = new FilterResults();
                List<Car> suggestions = new ArrayList<>();

                if (constraint == null || constraint.length()==0){

                    /// in public CustomAdapter( originalCars = new ArrayList<>(cars);) creates a copy of original results

                    suggestions.addAll(originalCars);
                }else{
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for (Car item : cars){
                        if (item.getPlateNumber().toLowerCase().contains(filterPattern)){
                            suggestions.add(item);
                        }
                    }

                }

               results.values = suggestions;
               results.count = suggestions.size();
               return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                clear();
                addAll((List) results.values);
                notifyDataSetChanged();
            }

            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return ((Car) resultValue).getPlateNumber();
            }
        };






    private Filter batteryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            // Create a FilterResults object
            FilterResults results = new FilterResults();
            List<Car> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length()==0){

                /// in public CustomAdapter( originalCars = new ArrayList<>(cars);) creates a copy of original results

                suggestions.addAll(originalCars);
            }else{
                Integer filterPattern =  Integer.parseInt(constraint.toString());
                for (Car item : cars){
                    if (item.getBatteryPercentage() > filterPattern){
                        suggestions.add(item);
                    }
                }

            }

            results.values = suggestions;
            results.count = suggestions.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Car) resultValue).getBatteryPercentage().toString();
        }



    };
    }



