package com.volcaniccoder.mobilgarson.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.login.LoginActivity;
import com.volcaniccoder.mobilgarson.login.LoginPresenterImpl;
import com.volcaniccoder.mobilgarson.models.RestaurantModel;
import com.volcaniccoder.mobilgarson.operations.OperationsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements IDashboardView , OnAdapterClickListener {

    @BindView(R.id.activityDashboardRecyclerView)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private IDashboardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        init();
    }

    @Override
        public void init(){

            presenter = new DashboardPresenter(this,((MobilGarsonApp) getApplication()));

            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            presenter.getRestaurants();
        }

    public void listRestaurants(List<RestaurantModel> restaurantModelList){
        mAdapter = new DashboardAdapter(restaurantModelList,this,this ,((MobilGarsonApp) getApplication()));
        mRecyclerView.setAdapter(mAdapter);
    }

    public void errorMessage(){
        Toast.makeText(this, "Hata", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickAdapterListener(View view, int position) {
        Intent intent = new Intent(this, OperationsActivity.class);
        Toast.makeText(this, "" + DashboardAdapter.restaurantId + "-"+ LoginPresenterImpl.userId + "", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

    @Override
    public void onLongClickAdapterListener(View view, int position) {

    }

    @Override
    public void onBackPressed() {}
}
