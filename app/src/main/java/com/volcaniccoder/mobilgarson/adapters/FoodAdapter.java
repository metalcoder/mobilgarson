package com.volcaniccoder.mobilgarson.adapters;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.listeners.OnFoodOrderClickListener;
import com.volcaniccoder.mobilgarson.models.FoodModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {


    private List<FoodModel> model;
    private OnAdapterClickListener listener;
    private OnFoodOrderClickListener orderListener;
    private Context mContext;

    public FoodAdapter(List<FoodModel> model, OnAdapterClickListener listener,
                       OnFoodOrderClickListener orderListener, Context context) {
        this.model = model;
        this.listener = listener;
        this.orderListener = orderListener;
        this.mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final FoodModel foodModel = model.get(position);

        holder.foodTitle.setText(foodModel.getFoodName());
        holder.foodRating.setText(Float.toString(foodModel.getFoodRating()));

        Picasso.with(mContext)
                .load(foodModel.getImageUrl1())
                .fit()
                .into(holder.foodImageFirst);

        Picasso.with(mContext)
                .load(foodModel.getImageUrl2())
                .fit()
                .into(holder.foodImageSecond);

        Picasso.with(mContext)
                .load(foodModel.getImageUrl3())
                .fit()
                .into(holder.foodImageThird);

        holder.foodPrice.setText(foodModel.getFoodPrice());


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(mContext, R.array.food_count_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.foodSpinner.setAdapter(adapter);

        holder.foodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                foodModel.setAmountOfOrder(Integer.parseInt((String) parent.getItemAtPosition(position)));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        holder.foodButtonRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickAdapterListener(v, -1);
            }
        });

        holder.foodButtonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderListener.onClickFoodOrderListener(v, foodModel);
            }
        });

        holder.foodOrderLayout.setVisibility(View.GONE);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.foodOrderLayout.getVisibility() == View.VISIBLE)
                    holder.foodOrderLayout.setVisibility(View.GONE);
                else
                    holder.foodOrderLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_food)
        CardView parentLayout;
        @BindView(R.id.foodTitle)
        TextView foodTitle;
        @BindView(R.id.foodRating)
        TextView foodRating;
        @BindView(R.id.foodImageFirst)
        ImageView foodImageFirst;
        @BindView(R.id.foodImageSecond)
        ImageView foodImageSecond;
        @BindView(R.id.foodImageThird)
        ImageView foodImageThird;
        @BindView(R.id.foodPrice)
        TextView foodPrice;
        @BindView(R.id.foodSpinner)
        Spinner foodSpinner;
        @BindView(R.id.foodButtonRate)
        Button foodButtonRate;
        @BindView(R.id.foodButtonOrder)
        Button foodButtonOrder;
        @BindView(R.id.foodOrderLayout)
        LinearLayout foodOrderLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
