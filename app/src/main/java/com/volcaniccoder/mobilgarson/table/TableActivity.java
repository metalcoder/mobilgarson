package com.volcaniccoder.mobilgarson.table;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.TableAdapter;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.models.pojo.TableResult;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TableActivity extends AppCompatActivity implements ITableView, OnAdapterClickListener {

    @BindView(R.id.activityTableRecyclerView)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private ITablePresenter presenter;
    private List<TableResult> tableResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        ButterKnife.bind(this);
        init();
    }

    public void init(){
        presenter = new TablePresenterImpl(this,((MobilGarsonApp)getApplication()));

        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        presenter.getTables();
    }

    @Override
    public void listRestaurants(List<TableResult> tablesList , long tableId) {
        this.tableResults = tablesList;
        mAdapter = new TableAdapter(tablesList,tableId,this,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void error() {

    }

    @Override
    public void tableChoosen() {
        finish();
    }

    @Override
    public void onClickAdapterListener(View view, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(tableResults.get(position).getName());
        builder.setMessage(tableResults.get(position).getCapacity() +
                " kişi kapasiteli masayı seçiyor musunuz?");
        builder.setPositiveButton("SEÇ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.openTable((long)tableResults.get(position).getId());
            }
        });
        builder.setNegativeButton("IPTAL",null);
        builder.create().show();
    }

    @Override
    public void onLongClickAdapterListener(View view, int position) {

    }
}
