package com.volcaniccoder.mobilgarson.di;

import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.adapters.FoodAdapter;
import com.volcaniccoder.mobilgarson.dashboard.DashboardPresenter;
import com.volcaniccoder.mobilgarson.login.LoginActivity;
import com.volcaniccoder.mobilgarson.login.LoginPresenterImpl;
import com.volcaniccoder.mobilgarson.register.RegisterPresenterImpl;
import com.volcaniccoder.mobilgarson.reservation.ReservationPresenterImpl;
import com.volcaniccoder.mobilgarson.restaurant.foods.FoodsPresenter;
import com.volcaniccoder.mobilgarson.restaurant.rating.RatingPresenter;
import com.volcaniccoder.mobilgarson.restaurant.tasks.TaskPresenterImpl;
import com.volcaniccoder.mobilgarson.table.TablePresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by volkan on 05.10.2016.
 */

@Singleton
@Component(modules = {AppModule.class,NetModule.class})
public interface NetComponent {

    void inject(LoginPresenterImpl loginPresenter);

    void inject(DashboardPresenter dashboardPresenter);

    void inject(DashboardAdapter dashboardAdapter);

    void inject(RatingPresenter ratingPresenter);

    void inject(FoodAdapter foodAdapter);

    void inject(FoodsPresenter foodsPresenter);

    void inject(RegisterPresenterImpl registerPresenter);

    void inject(TablePresenterImpl tablePresenter);

    void inject(ReservationPresenterImpl reservationPresenter);

    void inject(TaskPresenterImpl taskPresenter);

    void inject(LoginActivity loginActivity);
}
