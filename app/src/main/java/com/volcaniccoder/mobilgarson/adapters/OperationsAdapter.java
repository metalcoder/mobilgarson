package com.volcaniccoder.mobilgarson.adapters;


import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
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
import com.volcaniccoder.mobilgarson.models.OperationModel;
import com.volcaniccoder.mobilgarson.models.RestaurantModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OperationsAdapter extends RecyclerView.Adapter<OperationsAdapter.ViewHolder> {

    private List<OperationModel> model;
    private OnAdapterClickListener listener;
    private Context mContext;

    public OperationsAdapter(List<OperationModel> model , OnAdapterClickListener listener ,Context context){
        this.model = model;
        this.listener = listener;
        this.mContext = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_operations, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        OperationModel operationModel = model.get(position);

        holder.operationName.setText(operationModel.getTitle());

        holder.operationLogo.setImageDrawable(ContextCompat.getDrawable(mContext,operationModel.getDrawable()));

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

        @BindView(R.id.item_operations)
        LinearLayout parentLayout;
        @BindView(R.id.itemOperationsImageView)
        ImageView operationLogo;
        @BindView(R.id.itemOperationsTextView)
        TextView operationName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
