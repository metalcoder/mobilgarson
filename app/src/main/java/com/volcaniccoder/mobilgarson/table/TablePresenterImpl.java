package com.volcaniccoder.mobilgarson.table;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.models.pojo.TableResult;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by volkan.sahin on 21.12.2016.
 */

public class TablePresenterImpl implements ITablePresenter {

    private ITableView view;

    @Inject
    MobilGarsonService service;

    public static long tableId = -1;

    public TablePresenterImpl(ITableView view, MobilGarsonApp application) {
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
    public void openTable(final long id) {
        service.openTable(tableId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                    tableId = id;
                    view.tableChoosen();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                view.error();
            }
        });
    }
}
