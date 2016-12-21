package com.volcaniccoder.mobilgarson.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.volcaniccoder.mobilgarson.models.FragmentTabModel;

import java.util.List;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<FragmentTabModel> tabModelList;

    public ViewPagerAdapter(FragmentManager fragmentManager,List<FragmentTabModel> tabModelList) {
        super(fragmentManager);
        this.tabModelList = tabModelList;
    }

    @Override
    public Fragment getItem(int position) {
        return tabModelList.get(position).getTabFragment();
    }

    @Override
    public int getCount() {
        return tabModelList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabModelList.get(position).getTabName();
    }


}
