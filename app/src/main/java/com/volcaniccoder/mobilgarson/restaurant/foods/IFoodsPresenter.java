package com.volcaniccoder.mobilgarson.restaurant.foods;

import com.volcaniccoder.mobilgarson.models.FoodModel;

import java.util.List;

public interface IFoodsPresenter {

    void getFoods();

    void giveOrder(long productId , int piece);
}
