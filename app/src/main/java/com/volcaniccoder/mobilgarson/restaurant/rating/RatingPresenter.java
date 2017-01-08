package com.volcaniccoder.mobilgarson.restaurant.rating;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.login.LoginPresenterImpl;
import com.volcaniccoder.mobilgarson.models.CommentModel;
import com.volcaniccoder.mobilgarson.models.pojo.RestaurantCommentResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatingPresenter implements IRatingPresenter {

    private IRatingView view;

    @Inject
    MobilGarsonService service;

    public RatingPresenter(IRatingView view, MobilGarsonApp application) {
        this.view = view;
        application.getNetComponent().inject(this);
    }

    @Override
    public void getComments() {

        service.getRestaurantComments(DashboardAdapter.restaurantId).enqueue(new Callback<List<RestaurantCommentResult>>() {
            @Override
            public void onResponse(Call<List<RestaurantCommentResult>> call, Response<List<RestaurantCommentResult>> response) {
                List<RestaurantCommentResult> commentResults = response.body();

                if (commentResults != null) {
                    List<CommentModel> commentModelList = new ArrayList<CommentModel>();
                    for (RestaurantCommentResult result : commentResults) {
                        commentModelList.add(new CommentModel(result.getComment(), result.getDate()));
                    }
                    view.listComments(commentModelList);
                } else {
                    view.error();
                }
            }

            @Override
            public void onFailure(Call<List<RestaurantCommentResult>> call, Throwable t) {
                view.error();
            }
        });

    }

    @Override
    public void createComment(String comment) {
        service.createComment((long) LoginPresenterImpl.userId, (long) DashboardAdapter.restaurantId, comment).enqueue(new Callback<RestaurantCommentResult>() {
            @Override
            public void onResponse(Call<RestaurantCommentResult> call, Response<RestaurantCommentResult> response) {
                RestaurantCommentResult result = response.body();

                if (result != null) {
                    view.refreshComments();
                } else {
                    view.error();
                }
            }

            @Override
            public void onFailure(Call<RestaurantCommentResult> call, Throwable t) {
                view.error();
            }
        });
    }

    @Override
    public void createComplaint(String complaint) {
        service.createComplaint((long) LoginPresenterImpl.userId, (long) DashboardAdapter.restaurantId, complaint).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                if ( response != null) {
                    view.refreshComments();
                } else {
                    view.error();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                view.error();
            }
        });
    }
}
