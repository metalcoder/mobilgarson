package com.volcaniccoder.mobilgarson.adapters;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.models.RestaurantModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private List<RestaurantModel> model;
    private OnAdapterClickListener listener;
    private Context mContext;

    public DashboardAdapter(List<RestaurantModel> model , OnAdapterClickListener listener , Context context){
        this.model = model;
        this.listener = listener;
        this.mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        RestaurantModel restaurantModel = model.get(position);

        holder.restaurantName.setText(restaurantModel.getRestaurantName());
        holder.restaurantPoint.setText(Float.toString(restaurantModel.getQualityPoint()));
        holder.restaurantInfo.setText(restaurantModel.getRestaurantInfo());

        Picasso.with(mContext)
                .load(restaurantModel.getImageUrl())
                .fit()
                .into(holder.restaurantLogo);


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
