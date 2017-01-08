package com.volcaniccoder.mobilgarson.restaurant.tasks;

import android.content.SharedPreferences;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.models.pojo.BillResult;
import com.volcaniccoder.mobilgarson.models.pojo.EmployeeResult;
import com.volcaniccoder.mobilgarson.models.pojo.RequestResult;
import com.volcaniccoder.mobilgarson.restaurant.rating.IRatingView;
import com.volcaniccoder.mobilgarson.table.TablePresenterImpl;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by volkan.sahin on 7.01.2017.
 */

public class TaskPresenterImpl implements ITaskPresenter {

    private ITaskView view;

    @Inject
    MobilGarsonService service;
    @Inject
    SharedPreferences preferences;

    public TaskPresenterImpl(ITaskView view, MobilGarsonApp application) {
        this.view = view;
        application.getNetComponent().inject(this);
    }

    @Override
    public void getWaiterList() {
        service.getEmployees(DashboardAdapter.restaurantId).enqueue(new Callback<List<EmployeeResult>>() {
            @Override
            public void onResponse(Call<List<EmployeeResult>> call, Response<List<EmployeeResult>> response) {
                if (response != null && response.body() != null){
                    view.showWaiterList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeResult>> call, Throwable t) {

            }
        });
    }

    @Override
    public void createRequest(long userId, long restId, long garsonId) {
        long tableId = preferences.getLong("tableId",-1);
        if (tableId == -1){
            view.tableNotChoosedError();
        }else {
            service.createRequest(tableId, userId, restId, garsonId).enqueue(new Callback<RequestResult>() {
                @Override
                public void onResponse(Call<RequestResult> call, Response<RequestResult> response) {
                    if (response != null && response.body() != null) {
                        view.messageWaiter();
                    }
                }

                @Override
                public void onFailure(Call<RequestResult> call, Throwable t) {
                    view.error();
                }
            });
        }
    }

    @Override
    public void getBill() {
        long tableId = preferences.getLong("tableId",-1);
        if (tableId == -1){
            view.tableNotChoosedError();
        }else {
            service.getBill(tableId).enqueue(new Callback<BillResult>() {
                @Override
                public void onResponse(Call<BillResult> call, Response<BillResult> response) {
                    if (response !=null && response.body() !=null){
                        view.showBillResult(response.body());
                    }
                }

                @Override
                public void onFailure(Call<BillResult> call, Throwable t) {
                    view.error();
                }
            });
        }
    }
}
