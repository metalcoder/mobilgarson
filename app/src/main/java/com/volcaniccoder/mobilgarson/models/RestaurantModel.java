package com.volcaniccoder.mobilgarson.models;

public class RestaurantModel {

    private String restaurantName;
    private String imageUrl;

    public RestaurantModel(String restaurantName,String imageUrl) {
        this.imageUrl = imageUrl;
        this.restaurantName = restaurantName;
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
}
