package com.volcaniccoder.mobilgarson.reservation;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.models.pojo.TableResult;
import com.volcaniccoder.mobilgarson.register.IRegisterView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by volkan.sahin on 7.01.2017.
 */

public class ReservationPresenterImpl implements IReservationPresenter {

    @Inject
    MobilGarsonService service;
    IReservationView view;

    public ReservationPresenterImpl(IReservationView view ,MobilGarsonApp application) {
        this.view = view;
        application.getNetComponent().inject(this);
    }


    @Override
    public void getTables() {
        service.getRestaurantTables(DashboardAdapter.restaurantId).enqueue(new Callback<List<TableResult>>() {
            @Override
            public void onResponse(Call<List<TableResult>> call, Response<List<TableResult>> response) {
                List<TableResult> tableResults = response.body();

                if (tableResults != null) {
                    view.listRestaurants(tableResults);
                } else {
                    view.error();
                }
            }

            @Override
            public void onFailure(Call<List<TableResult>> call, Throwable t) {
                view.error();
            }
        });
    }

    @Override
    public void createReservation(long restaurantId, String date, String clock, long userId, String name, String surname, long tableId) {

    }

}
