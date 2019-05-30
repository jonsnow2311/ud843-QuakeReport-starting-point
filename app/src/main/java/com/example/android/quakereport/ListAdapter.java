package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ASUS on 21-05-2019.
 */


public class ListAdapter extends ArrayAdapter<Earthquake> {

    public ListAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitudeTextView);
        double input = currentEarthquake.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(input);
        magnitudeTextView.setText(output);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor((int)currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        String originalLocation = currentEarthquake.getPlace();
        String primaryLocation;
        String locationOffset;
        final String LOCATION_SEPARATOR = " of ";
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = "Near the";
            primaryLocation = originalLocation;
        }
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primaryLocation);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.locationOffset);
        locationOffsetView.setText(locationOffset);

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.timeTextView);

        long timeInMilliSeconds = currentEarthquake.getTime();
        Date dateObject = new Date(timeInMilliSeconds);
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormat.format(dateObject);
        timeTextView.setText(timeToDisplay);

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.dateTextView);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD,YYYY");
        String dateToDisplay = dateFormatter.format(dateObject);
        dateTextView.setText(dateToDisplay);


        return listItemView;
    }

    public int getMagnitudeColor(int magnitude)
    {
        int value=0;
        switch(magnitude)
        {
            case 1: value = ContextCompat.getColor(getContext(), R.color.magnitude1);
                    break;
            case 2: value = ContextCompat.getColor(getContext(), R.color.magnitude2);
                    break;
            case 3: value = ContextCompat.getColor(getContext(), R.color.magnitude3);
                    break;
            case 4: value = ContextCompat.getColor(getContext(), R.color.magnitude4);
                    break;
            case 5: value = ContextCompat.getColor(getContext(), R.color.magnitude5);
                    break;
            case 6: value = ContextCompat.getColor(getContext(), R.color.magnitude6);
                    break;
            case 7: value = ContextCompat.getColor(getContext(), R.color.magnitude7);
                    break;
            case 8: value = ContextCompat.getColor(getContext(), R.color.magnitude8);
                    break;
            case 9: value = ContextCompat.getColor(getContext(), R.color.magnitude9);
                    break;
            case 10:value = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                    break;

        }
        if(magnitude>10)
        {
            value = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
        }
        return value;
    }
}
