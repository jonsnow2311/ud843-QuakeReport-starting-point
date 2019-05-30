package com.example.android.quakereport;

import java.sql.Time;

/**
 * Created by ASUS on 21-05-2019.
 */

public class Earthquake {

    private double magnitude;
    private String place;
    private long time;
    private String url;

    public Earthquake (double mMagnitude , String mPlace , long mTime , String mUrl)
    {
        magnitude=mMagnitude;
        place=mPlace;
        time=mTime;
        url=mUrl;
    }

    public double getMagnitude()
    {
        return magnitude;
    }
    public String getPlace()
    {
        return place;
    }
    public long getTime()
    {
        return time;
    }
    public String getUrl()
    {
        return url;
    }
}
