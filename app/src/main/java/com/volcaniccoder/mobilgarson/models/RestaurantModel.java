package com.volcaniccoder.mobilgarson.models;

public class RestaurantModel {

    private String restaurantName;
    private String imageUrl;
    private String restaurantInfo;
    private float qualityPoint;

    public RestaurantModel(String restaurantName,String imageUrl,String restaurantInfo,float qualityPoint) {
        this.imageUrl = imageUrl;
        this.restaurantName = restaurantName;
        this.restaurantInfo = restaurantInfo;
        this.qualityPoint = qualityPoint;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRestaurantInfo() {
        return restaurantInfo;
    }

    public void setRestaurantInfo(String restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }

    public float getQualityPoint() {
        return qualityPoint;
    }

    public void setQualityPoint(float qualityPoint) {
        this.qualityPoint = qualityPoint;
    }
}
