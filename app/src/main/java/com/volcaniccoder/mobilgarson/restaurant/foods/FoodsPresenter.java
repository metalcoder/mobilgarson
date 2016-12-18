package com.volcaniccoder.mobilgarson.restaurant.foods;

import com.volcaniccoder.mobilgarson.models.FoodModel;

import java.util.ArrayList;
import java.util.List;

public class FoodsPresenter implements IFoodsPresenter{

    IFoodsView view;

    public FoodsPresenter(IFoodsView view){
        this.view = view;
    }

    @Override
    public List<FoodModel> getFoods() {
        List<FoodModel> foodList = new ArrayList<>();

        FoodModel model = new FoodModel("Tavuk Döner","3 TL" , 8.7f);
        model.setImageUrl1("http://dugundonercisi.com/images/d81dc02bf3617af66231f06078e691f5_donerekmekdugun.png");
        model.setImageUrl2("http://www.medyalideri.com/uploads/urun/1469006241_tavuk_sis_durum.jpg");
        model.setImageUrl3("http://i.milliyet.com.tr/YeniAnaResim/2014/10/23/fft99_mf4902736.Jpeg");

        FoodModel model1 = new FoodModel("İskender","16 TL" , 7.2f);
        model1.setImageUrl1("http://www.aydinlariskender.com.tr/userfiles/images/urunler/253146_3e26.jpg");
        model1.setImageUrl2("http://ustadyemekkebap.com/wp-content/uploads/2014/11/u141532008106163484.jpg");
        model1.setImageUrl3("https://media-cdn.tripadvisor.com/media/photo-s/08/8a/bb/34/iskender-kebap.jpg");

        FoodModel model2 = new FoodModel("Kebap","14 TL" , 9.8f);
        model2.setImageUrl1("http://www.zerenkebap.com/resources/upload/images/big-22-01-2014_23-45-41_7066254.jpg");
        model2.setImageUrl2("http://bayramustayaprakkebap.com/wp-content/uploads/2015/02/adana-kebabi.jpg");
        model2.setImageUrl3("https://media-cdn.tripadvisor.com/media/photo-s/07/7c/49/f2/karisik-kebap.jpg");

        FoodModel model3 = new FoodModel("Hamburger","7 TL" , 5.3f);
        model3.setImageUrl1("http://combiboilersleeds.com/images/hamburger/hamburger-0.jpg");
        model3.setImageUrl2("http://image.cdn.iha.com.tr/Contents/store/img/1124000/1124138.jpg");
        model3.setImageUrl3("https://www.rhodesbread.com/images/recipes/HamburgerBunsLarge.jpg");

        foodList.add(model);
        foodList.add(model1);
        foodList.add(model2);
        foodList.add(model3);

        return foodList;
    }
}
