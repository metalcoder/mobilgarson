package com.volcaniccoder.mobilgarson.dashboard;

import android.util.Log;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.models.RestaurantModel;
import com.volcaniccoder.mobilgarson.models.pojo.RestaurantImageResult;
import com.volcaniccoder.mobilgarson.models.pojo.RestaurantResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardPresenter implements IDashboardPresenter{

    private IDashboardView view;

    @Inject
    MobilGarsonService service;

    public DashboardPresenter(IDashboardView view , MobilGarsonApp application){
        application.getNetComponent().inject(this);
        this.view = view;
    }

    @Override
    public void getRestaurants() {

        service.getRestaurants().enqueue(new Callback<List<RestaurantResult>>() {
            @Override
            public void onResponse(Call<List<RestaurantResult>> call, Response<List<RestaurantResult>> response) {
                List<RestaurantResult> restaurantResults = response.body();
                if (restaurantResults != null) {
                    final List<RestaurantModel> modelList = new ArrayList<>();
                    for (RestaurantResult restaurantResult : restaurantResults) {
                        final RestaurantModel model = new RestaurantModel(restaurantResult.getName(),"https://s-media-cache-ak0.pinimg.com/originals/e8/cb/48/e8cb48d2ee29eaf58a4f8da10dec3c07.png",
                                restaurantResult.getDefinition(),(float) restaurantResult.getServiceScore());
                        model.setRestaurantId(restaurantResult.getId());
                        modelList.add(model);
                    }

                    view.listRestaurants(modelList);
                }else {
                    view.errorMessage();
                }
            }

            @Override
            public void onFailure(Call<List<RestaurantResult>> call, Throwable t) {
                Log.w("RETROFIT",t.getMessage());
                view.errorMessage();
            }
        });

        //mockdata
//        List<RestaurantModel> modelList = new ArrayList<>();
//        modelList.add(new RestaurantModel("BurgerKing" ,
//                "https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/Burger_King_Logo.svg/1024px-Burger_King_Logo.svg.png","Uluslararası restoran zincirinin Türkiye sitesinde firma ve ürünleri hakkında bilgiler, online sipariş, franchising sistemiyle ilgili bilgiler ve franchise başvuru formu ",5.2f));
//        modelList.add(new RestaurantModel("McDonalds",
//                "https://s-media-cache-ak0.pinimg.com/originals/e8/cb/48/e8cb48d2ee29eaf58a4f8da10dec3c07.png","McDonald's Türkiye web sitesine hoş geldiniz. McDonald's AloServis ile sipariş verebilir, kampanyalara ve size en yakın restoranlara ulaşabilirsiniz.",5.8f));
//        modelList.add(new RestaurantModel("KFC",
//                "https://static.festisite.com/static/partylogo/img/logos/kfc.png","Kentucky Fried Chicken web sitesinden leziz parça tavuk ve tavuk burger menülerini online sipariş verebilir, kampanyalara ve size en yakın restoranlara ",6.4f));
//        modelList.add(new RestaurantModel("Pizza Hut",
//                "http://vignette3.wikia.nocookie.net/logopedia/images/b/b6/Pizza_Hut_Logo_2.jpg/revision/latest?cb=20150622080051"));
//        modelList.add(new RestaurantModel("Kasap Döner",
//                "http://bayimolurmusun.com.tr/firma_logo/kasap.jpg"));
//
//        return modelList;
    }
}
