package com.volcaniccoder.mobilgarson.operations;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.ViewPagerAdapter;
import com.volcaniccoder.mobilgarson.dashboard.IDashboardPresenter;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.models.FragmentTabModel;
import com.volcaniccoder.mobilgarson.models.OperationModel;
import com.volcaniccoder.mobilgarson.restaurant.foods.FoodsFragment;
import com.volcaniccoder.mobilgarson.restaurant.rating.RatingFragment;
import com.volcaniccoder.mobilgarson.restaurant.tasks.RestaurantFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OperationsActivity extends AppCompatActivity implements OnAdapterClickListener {

    //@BindView(R.id.activityOperationsRecyclerView)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private IDashboardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
        ButterKnife.bind(this);
        init();
    }

    public void init(){

//        mRecyclerView = (RecyclerView) findViewById(R.id.activityOperationsRecyclerView);
//        presenter = new DashboardPresenter(this);
//
//        mLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        mAdapter = new OperationsAdapter(getOperations(),this,this);
//        mRecyclerView.setAdapter(mAdapter);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setupViewPager(ViewPager viewPager){

        List<FragmentTabModel> tabsList = new ArrayList<>();
        tabsList.add(new FragmentTabModel(new FoodsFragment(),"Yemekler",0));
        tabsList.add(new FragmentTabModel(new RestaurantFragment(),"İşlemler",0));
        tabsList.add(new FragmentTabModel(new RatingFragment(),"Değerlendirme",0));

        ViewPagerAdapter tabsAdapter = new ViewPagerAdapter(getSupportFragmentManager(),tabsList);
        viewPager.setAdapter(tabsAdapter);
    }

    public List<OperationModel> getOperations(){

        List<OperationModel> model = new ArrayList<>();
        model.add(new OperationModel("Yemek Listesi",android.R.drawable.star_big_on));
        model.add(new OperationModel("Rezervasyon",android.R.drawable.star_big_on));
        model.add(new OperationModel("Puanlama",android.R.drawable.star_big_on));
        model.add(new OperationModel("Hakkında",android.R.drawable.star_big_on));
        model.add(new OperationModel("Garson Çağır",android.R.drawable.star_big_on));
        model.add(new OperationModel("Hesap İste",android.R.drawable.star_big_on));

        return model;
    }
    @Override
    public void onClickAdapterListener(View view, int position) {

    }

    @Override
    public void onLongClickAdapterListener(View view, int position) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
