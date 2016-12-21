package com.volcaniccoder.mobilgarson.dashboard;

import com.volcaniccoder.mobilgarson.models.RestaurantModel;

import java.util.List;

public interface IDashboardView {

    void init();

    void listRestaurants(List<RestaurantModel> restaurantModelList);

    void errorMessage();
}
