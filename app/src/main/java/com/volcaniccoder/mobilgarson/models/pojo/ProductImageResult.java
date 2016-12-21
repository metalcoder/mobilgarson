package com.volcaniccoder.mobilgarson.models.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by volkan.sahin on 20.12.2016.
 */

public class ProductImageResult {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("imagestring")
    @Expose
    private String imagestring;
    @SerializedName("productid")
    @Expose
    private int productid;

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

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
}
