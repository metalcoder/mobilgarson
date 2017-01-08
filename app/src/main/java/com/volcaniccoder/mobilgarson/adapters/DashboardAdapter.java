package com.volcaniccoder.mobilgarson.adapters;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.api.MobilGarsonService;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.models.RestaurantModel;
import com.volcaniccoder.mobilgarson.models.pojo.RestaurantImageResult;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private List<RestaurantModel> model;
    private OnAdapterClickListener listener;
    private Context mContext;

    public static int restaurantId;
    @Inject
    MobilGarsonService service;

    public DashboardAdapter(List<RestaurantModel> model , OnAdapterClickListener listener , Context context , MobilGarsonApp application){
        this.model = model;
        this.listener = listener;
        this.mContext = context;
        application.getNetComponent().inject(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final RestaurantModel restaurantModel = model.get(position);

        holder.restaurantName.setText(restaurantModel.getRestaurantName());
        holder.restaurantPoint.setText(Float.toString(restaurantModel.getQualityPoint()));
        holder.restaurantInfo.setText(restaurantModel.getRestaurantInfo());

        service.getRestaurantImageUrl((long) restaurantModel.getRestaurantId()).enqueue(new Callback<List<RestaurantImageResult>>() {
            @Override
            public void onResponse(Call<List<RestaurantImageResult>> call, Response<List<RestaurantImageResult>> response) {
                String imageUrl = response.body().get(0).getImagestring();

//                byte[] decoded = Base64.decode(imageUrl,Base64.DEFAULT);
//                Bitmap bmp = BitmapFactory.decodeByteArray(decoded, 0, decoded.length);

                restaurantModel.setImageUrl(imageUrl);
                Picasso.with(mContext)
                        //.load(bmp)
                        .load(restaurantModel.getImageUrl())
                        .fit()
                        .into(holder.restaurantLogo);
            }

            @Override
            public void onFailure(Call<List<RestaurantImageResult>> call, Throwable t) {
                Log.w("retro",t.getMessage());
            }
        });
//        service.getRestaurantImageUrl((long) restaurantModel.getRestaurantId()).enqueue(new Callback<RestaurantImageResult>() {
//            @Override
//            public void onResponse(Call<RestaurantImageResult> call, Response<RestaurantImageResult> response) {
//                String imageUrl = null;
//                try {
//                    imageUrl = service.getRestaurantImageUrl((long) restaurantModel.getRestaurantId()).execute().body().getImagestring();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                restaurantModel.setImageUrl(imageUrl);
//                Picasso.with(mContext)
//                        .load(restaurantModel.getImageUrl())
//                        .fit()
//                        .into(holder.restaurantLogo);
//            }
//
//            @Override
//            public void onFailure(Call<RestaurantImageResult> call, Throwable t) {
//                Log.w("retro",t.getMessage());
//            }
//        });

//        try {
//            String imageUrl = service.getRestaurantImageUrl((long) restaurantModel.getRestaurantId()).execute().body().getImagestring();
//            restaurantModel.setImageUrl(imageUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Picasso.with(mContext)
//                .load(restaurantModel.getImageUrl())
//                .fit()
//                .into(holder.restaurantLogo);


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantId = restaurantModel.getRestaurantId();
                listener.onClickAdapterListener(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_dashboard)
        LinearLayout parentLayout;
        @BindView(R.id.itemDashboardImageView)
        ImageView restaurantLogo;
        @BindView(R.id.itemDashboardTextView)
        TextView restaurantName;
        @BindView(R.id.itemDashboardPointTextView)
        TextView restaurantPoint;
        @BindView(R.id.itemDashboardInfoTextView)
        TextView restaurantInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
