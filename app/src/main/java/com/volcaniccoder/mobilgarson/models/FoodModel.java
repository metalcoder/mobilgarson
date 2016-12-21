package com.volcaniccoder.mobilgarson.models;

public class FoodModel {

    private int foodId;
    private String foodName;
    private String foodPrice;
    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private float foodRating;
    private int amountOfOrder;

    public FoodModel(String foodName, String foodPrice, float foodRating) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodRating = foodRating;
        this.amountOfOrder = 1;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getImageUrl3() {
        return imageUrl3;
    }

    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(float foodRating) {
        this.foodRating = foodRating;
    }

    public int getAmountOfOrder() {
        return amountOfOrder;
    }

    public void setAmountOfOrder(int amountOfOrder) {
        this.amountOfOrder = amountOfOrder;
    }
}
