package com.volcaniccoder.mobilgarson.api;

import com.volcaniccoder.mobilgarson.models.pojo.BillResult;
import com.volcaniccoder.mobilgarson.models.pojo.EmployeeResult;
import com.volcaniccoder.mobilgarson.models.pojo.LoginUserResult;
import com.volcaniccoder.mobilgarson.models.pojo.OrderResult;
import com.volcaniccoder.mobilgarson.models.pojo.ProductImageResult;
import com.volcaniccoder.mobilgarson.models.pojo.ProductResult;
import com.volcaniccoder.mobilgarson.models.pojo.RequestResult;
import com.volcaniccoder.mobilgarson.models.pojo.RestaurantCommentResult;
import com.volcaniccoder.mobilgarson.models.pojo.RestaurantImageResult;
import com.volcaniccoder.mobilgarson.models.pojo.RestaurantResult;
import com.volcaniccoder.mobilgarson.models.pojo.TableResult;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by volkan.sahin on 20.12.2016.
 */

public interface MobilGarsonService {

    @FormUrlEncoded
    @POST("userservice/user/login")
    Call<LoginUserResult> getLoginAuthentication(
            @Field("mail") String mail,
            @Field("password") String password
    );

    @FormUrlEncoded
    @PUT("userservice/user/create")
    Call<LoginUserResult> createUser(
            @Field("mail") String mail,
            @Field("password") String password,
            @Field("name") String name,
            @Field("surname") String surname
    );

    @GET("restaurantservice/restaurants")
    Call<List<RestaurantResult>> getRestaurants(
    );

    @GET("imageservice/restaurant/images/{id}")
    Call<List<RestaurantImageResult>> getRestaurantImageUrl(
            @Path("id") long id
    );

    @GET("restaurantcomment/comments/restaurant/{restaurantid}")
    Call<List<RestaurantCommentResult>> getRestaurantComments(
            @Path("restaurantid") long restaurantId
    );

    @FormUrlEncoded
    @PUT("restaurantcomment/comments")
    Call<RestaurantCommentResult> createComment(
            @Field("userid") long userId,
            @Field("restaurantid") long restaurantId,
            @Field("comment") String comment
    );

    @FormUrlEncoded
    @PUT("complaintservice/complaints")
    Call<Void> createComplaint(
            @Field("userid") long userId,
            @Field("restaurantid") long restaurantId,
            @Field("complainticerigi") String complaint
    );

    @GET("productservice/products/restaurant/{id}")
    Call<List<ProductResult>> getRestaurantProducts(
            @Path("id") long restaurantId
    );

    @GET("imageservice/product/images/{id}")
    Call<List<ProductImageResult>> getProductImageUrl(
            @Path("id") long productId
    );

    @GET("tableservice/tables/restaurant/{id}")
    Call<List<TableResult>> getRestaurantTables(
            @Path("id") long id
    );

    @FormUrlEncoded
    @POST("tableservice/tables/open")
    Call<String> openTable(
            @Field("tableid") long id
    );

    @FormUrlEncoded
    @PUT("orderservice/order/give")
    Call<OrderResult> giveOrder(
            @Field("restaurantid") long restId,
            @Field("productid") long productId,
            @Field("piece") long piece,
            @Field("tableid") long tableId
    );

    @GET("billservice/{tableid}")
    Call<BillResult> getBill(
        @Path("tableid") long id
    );

    @GET("employeeservice/employee/restaurant/{id}")
    Call<List<EmployeeResult>> getEmployees(
            @Path("id") long restaurantId
    );

    @FormUrlEncoded
    @PUT("requestservice")
    Call<RequestResult> createRequest(
            @Field("tableid") long tableId,
            @Field("userid") long userId,
            @Field("restaurantid") long restId,
            @Field("garsonid") long garsonId
    );

}
