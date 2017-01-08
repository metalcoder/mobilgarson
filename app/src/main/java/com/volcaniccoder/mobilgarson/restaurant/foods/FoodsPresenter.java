package com.volcaniccoder.mobilgarson.restaurant.foods;

import android.content.SharedPreferences;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.models.FoodModel;
import com.volcaniccoder.mobilgarson.models.pojo.OrderResult;
import com.volcaniccoder.mobilgarson.models.pojo.ProductResult;
import com.volcaniccoder.mobilgarson.table.TablePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodsPresenter implements IFoodsPresenter {

    IFoodsView view;

    @Inject
    MobilGarsonService service;
    @Inject
    SharedPreferences preferences;

    public FoodsPresenter(IFoodsView view, MobilGarsonApp application) {
        this.view = view;
        application.getNetComponent().inject(this);
    }

    @Override
    public void getFoods() {
        service.getRestaurantProducts(DashboardAdapter.restaurantId).enqueue(new Callback<List<ProductResult>>() {
            @Override
            public void onResponse(Call<List<ProductResult>> call, Response<List<ProductResult>> response) {
                List<ProductResult> productResults = response.body();

                if (productResults != null) {
                    List<FoodModel> foodModelList = new ArrayList<>();
                    for (ProductResult result : productResults) {
                        FoodModel food = new FoodModel(result.getName(), Integer.toString(result.getPrice()), (float) result.getScore());
                        food.setFoodId(result.getId());
                        foodModelList.add(food);
                    }
                    view.listFoods(foodModelList);
                } else {
                    view.error();
                }
            }

            @Override
            public void onFailure(Call<List<ProductResult>> call, Throwable t) {
                view.error();
            }
        });
    }

    @Override
    public void giveOrder(long productId, int piece) {
        long tableId = preferences.getLong("tableId",-1);
        if ( tableId == -1) {
            view.tableNotChoosedError();
        } else {
            service.giveOrder(DashboardAdapter.restaurantId, productId, piece, tableId).enqueue(new Callback<OrderResult>() {
                @Override
                public void onResponse(Call<OrderResult> call, Response<OrderResult> response) {
                    OrderResult result = response.body();
                    if (result != null) {
                        view.orderReceived();
                    } else {
                        view.error();
                    }

                }

                @Override
                public void onFailure(Call<OrderResult> call, Throwable t) {
                    view.error();
                }
            });
        }

    }

//    @Override
//    public List<FoodModel> getFoods() {
//        List<FoodModel> foodList = new ArrayList<>();
//
//        FoodModel model = new FoodModel("Tavuk Döner","3 TL" , 8.7f);
//        model.setImageUrl1("http://dugundonercisi.com/images/d81dc02bf3617af66231f06078e691f5_donerekmekdugun.png");
//        model.setImageUrl2("http://www.medyalideri.com/uploads/urun/1469006241_tavuk_sis_durum.jpg");
//        model.setImageUrl3("http://i.milliyet.com.tr/YeniAnaResim/2014/10/23/fft99_mf4902736.Jpeg");
//
//        FoodModel model1 = new FoodModel("İskender","16 TL" , 7.2f);
//        model1.setImageUrl1("http://www.aydinlariskender.com.tr/userfiles/images/urunler/253146_3e26.jpg");
//        model1.setImageUrl2("http://ustadyemekkebap.com/wp-content/uploads/2014/11/u141532008106163484.jpg");
//        model1.setImageUrl3("https://media-cdn.tripadvisor.com/media/photo-s/08/8a/bb/34/iskender-kebap.jpg");
//
//        FoodModel model2 = new FoodModel("Kebap","14 TL" , 9.8f);
//        model2.setImageUrl1("http://www.zerenkebap.com/resources/upload/images/big-22-01-2014_23-45-41_7066254.jpg");
//        model2.setImageUrl2("http://bayramustayaprakkebap.com/wp-content/uploads/2015/02/adana-kebabi.jpg");
//        model2.setImageUrl3("https://media-cdn.tripadvisor.com/media/photo-s/07/7c/49/f2/karisik-kebap.jpg");
//
//        FoodModel model3 = new FoodModel("Hamburger","7 TL" , 5.3f);
//        model3.setImageUrl1("http://combiboilersleeds.com/images/hamburger/hamburger-0.jpg");
//        model3.setImageUrl2("http://image.cdn.iha.com.tr/Contents/store/img/1124000/1124138.jpg");
//        model3.setImageUrl3("https://www.rhodesbread.com/images/recipes/HamburgerBunsLarge.jpg");
//
//        foodList.add(model);
//        foodList.add(model1);
//        foodList.add(model2);
//        foodList.add(model3);
//
//        return foodList;
//    }
}
