package com.volcaniccoder.mobilgarson.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.operations.OperationsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements IDashboardView , OnAdapterClickListener {

    //@BindView(R.id.activityDashboardRecyclerView)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private IDashboardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
    }

    @Override
    public void init(){

        mRecyclerView = (RecyclerView)findViewById(R.id.activityDashboardRecyclerView);
        presenter = new DashboardPresenter(this);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new DashboardAdapter(presenter.getRestaurants(),this,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClickAdapterListener(View view, int position) {
        startActivity(new Intent(this, OperationsActivity.class));
    }

    @Override
    public void onLongClickAdapterListener(View view, int position) {

    }
}
