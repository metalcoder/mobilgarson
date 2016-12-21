package com.volcaniccoder.mobilgarson.models.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by volkan.sahin on 21.12.2016.
 */

public class OrderResult {

    @SerializedName("restaurantid")
    @Expose
    private long restaurantid;
    @SerializedName("productid")
    @Expose
    private long productid;
    @SerializedName("piece")
    @Expose
    private int piece;
    @SerializedName("tableid")
    @Expose
    private int tableid;

    public long getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid) {
        this.restaurantid = restaurantid;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }
}
