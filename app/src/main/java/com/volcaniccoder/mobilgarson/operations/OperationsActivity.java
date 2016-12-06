package com.volcaniccoder.mobilgarson.operations;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.DashboardAdapter;
import com.volcaniccoder.mobilgarson.adapters.OperationsAdapter;
import com.volcaniccoder.mobilgarson.dashboard.DashboardPresenter;
import com.volcaniccoder.mobilgarson.dashboard.IDashboardPresenter;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.models.OperationModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OperationsActivity extends AppCompatActivity implements OnAdapterClickListener {

    //@BindView(R.id.activityOperationsRecyclerView)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private IDashboardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
        init();
    }

    public void init(){

        mRecyclerView = (RecyclerView) findViewById(R.id.activityOperationsRecyclerView);
        //presenter = new DashboardPresenter(this);

        mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new OperationsAdapter(getOperations(),this,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public List<OperationModel> getOperations(){

        List<OperationModel> model = new ArrayList<>();
        model.add(new OperationModel("Yemek Listesi",android.R.drawable.star_big_on));
        model.add(new OperationModel("Rezervasyon",android.R.drawable.star_big_on));
        model.add(new OperationModel("Puanlama",android.R.drawable.star_big_on));
        model.add(new OperationModel("Hakkında",android.R.drawable.star_big_on));

        return model;
    }
    @Override
    public void onClickAdapterListener(View view, int position) {

    }

    @Override
    public void onLongClickAdapterListener(View view, int position) {

    }
}
