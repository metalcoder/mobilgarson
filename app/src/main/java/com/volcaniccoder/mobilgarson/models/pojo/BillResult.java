package com.volcaniccoder.mobilgarson.models.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by volkan.sahin on 7.01.2017.
 */

public class BillResult {
    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("restaurantid")
    @Expose
    private int restaurantid;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.restaurantid = restaurantid;
    }

}
