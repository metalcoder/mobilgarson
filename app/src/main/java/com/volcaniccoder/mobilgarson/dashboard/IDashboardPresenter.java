package com.volcaniccoder.mobilgarson.dashboard;

import com.volcaniccoder.mobilgarson.models.RestaurantModel;

import java.util.List;

public interface IDashboardPresenter {
    List<RestaurantModel> getRestaurants();
}
