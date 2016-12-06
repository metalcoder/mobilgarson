package com.volcaniccoder.mobilgarson.dashboard;

import com.volcaniccoder.mobilgarson.models.RestaurantModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardPresenter implements IDashboardPresenter{

    private IDashboardView view;

    public DashboardPresenter(IDashboardView view){
        this.view = view;
    }

    @Override
    public List<RestaurantModel> getRestaurants() {

        //mockdata
        List<RestaurantModel> modelList = new ArrayList<>();
        modelList.add(new RestaurantModel("BurgerKing" ,
                "https://upload.wikimedia.org/wikipedia/en/thumb/3/3a/Burger_King_Logo.svg/1024px-Burger_King_Logo.svg.png"));
        modelList.add(new RestaurantModel("McDonalds",
                "https://s-media-cache-ak0.pinimg.com/originals/e8/cb/48/e8cb48d2ee29eaf58a4f8da10dec3c07.png"));
        modelList.add(new RestaurantModel("KFC",
                "https://static.festisite.com/static/partylogo/img/logos/kfc.png"));
        modelList.add(new RestaurantModel("Pizza Hut",
                "http://vignette3.wikia.nocookie.net/logopedia/images/b/b6/Pizza_Hut_Logo_2.jpg/revision/latest?cb=20150622080051"));
        modelList.add(new RestaurantModel("Kasap Döner",
                "http://bayimolurmusun.com.tr/firma_logo/kasap.jpg"));

        return modelList;
    }
}
