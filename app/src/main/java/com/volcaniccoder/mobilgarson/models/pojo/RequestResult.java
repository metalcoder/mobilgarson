package com.volcaniccoder.mobilgarson.models.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by volkan.sahin on 7.01.2017.
 */

public class RequestResult {
    @SerializedName("dinnertableid")
    @Expose
    private int dinnertableid;
    @SerializedName("garsonid")
    @Expose
    private int garsonid;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("restaurantid")
    @Expose
    private int restaurantid;
    @SerializedName("userid")
    @Expose
    private int userid;

    public int getDinnertableid() {
        return dinnertableid;
    }

    public void setDinnertableid(int dinnertableid) {
        this.dinnertableid = dinnertableid;
    }

    public int getGarsonid() {
        return garsonid;
    }

    public void setGarsonid(int garsonid) {
        this.garsonid = garsonid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
