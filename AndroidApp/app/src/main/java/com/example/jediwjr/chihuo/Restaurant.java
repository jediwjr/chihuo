package com.example.jediwjr.chihuo;

import android.graphics.Bitmap;

/**
 * Created by JediWJR on 1/8/17.
 */

public class Restaurant {
    /**
     * All data for a restaurant.
     */
    private String name;
    private String address;
    private String type;
    private double lat;
    private double lng;
    private Bitmap thumbnail;
    private Bitmap rating;


    /**
     * Constructor.
     */
    public Restaurant(String name, String address, String type, double lat, double lng, Bitmap thumbnail, Bitmap rating) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.thumbnail = thumbnail;
        this.rating = rating;
    }

    /**
     * Getters for private attributes of Restaurant class.
     */
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public Bitmap getRating() {
        return rating;
    }

}