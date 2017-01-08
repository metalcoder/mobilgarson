package com.volcaniccoder.mobilgarson.restaurant.foods;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.FoodAdapter;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.listeners.OnFoodOrderClickListener;
import com.volcaniccoder.mobilgarson.models.CommentModel;
import com.volcaniccoder.mobilgarson.models.FoodModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodsFragment extends Fragment implements IFoodsView, OnAdapterClickListener, OnFoodOrderClickListener {

    @BindView(R.id.foodRecyclerView)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private IFoodsPresenter presenter;
    private List<FoodModel> foodsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foods, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    public void init() {
        presenter = new FoodsPresenter(this, ((MobilGarsonApp)(getActivity().getApplication())));

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        presenter.getFoods();
    }

    @Override
    public void listFoods(List<FoodModel> foodsList) {
        mAdapter = new FoodAdapter(foodsList, this, this, getContext(), ((MobilGarsonApp)(getActivity().getApplication())));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void error() {
        Toast.makeText(getContext(), "Hata", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void orderReceived() {
        Toast.makeText(getContext(), "orderReceived", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickAdapterListener(View view, int position) {
        switch (view.getId()) {
            case R.id.foodButtonRate:
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_rate,null);
                final AppCompatRatingBar ratingBar = (AppCompatRatingBar) view1.findViewById(R.id.appCompatRatingBar);
                builder.setView(view1);
                builder.setTitle("Şimdi Puanla");
                builder.setPositiveButton("Puanla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "" + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("İptal",null);
                builder.create().show();
                Toast.makeText(getContext(), "foodButtonRate", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onLongClickAdapterListener(View view, int position) {

    }

    @Override
    public void onClickFoodOrderListener(View view, FoodModel foodModel) {
        switch (view.getId()) {
            case R.id.foodButtonOrder:
                Toast.makeText(getContext(), "foodButtonOrder" + ":" + foodModel.getAmountOfOrder(), Toast.LENGTH_SHORT).show();
                presenter.giveOrder(foodModel.getFoodId(),foodModel.getAmountOfOrder());
                break;
        }
    }

    @Override
    public void tableNotChoosedError() {
        Toast.makeText(getContext(), "Önce bir masa seçmelisiniz", Toast.LENGTH_SHORT).show();
    }

}
