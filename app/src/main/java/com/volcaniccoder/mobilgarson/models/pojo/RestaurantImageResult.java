package com.volcaniccoder.mobilgarson.models.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by volkan.sahin on 20.12.2016.
 */

public class RestaurantImageResult {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("imagestring")
    @Expose
    private String imagestring;
    @SerializedName("restaurantid")
    @Expose
    private int restaurantid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagestring() {
        return imagestring;
    }

    public void setImagestring(String imagestring) {
        this.imagestring = imagestring;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }
}
