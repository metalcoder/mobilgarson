package com.volcaniccoder.mobilgarson.restaurant.foods;

import com.volcaniccoder.mobilgarson.models.FoodModel;

import java.util.List;

public interface IFoodsView {

    void listFoods(List<FoodModel> foodsList);

    void error();

    void orderReceived();

    void tableNotChoosedError();
}
