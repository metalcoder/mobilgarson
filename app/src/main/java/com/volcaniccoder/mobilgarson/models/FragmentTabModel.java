package com.volcaniccoder.mobilgarson.models;

import android.support.v4.app.Fragment;

public class FragmentTabModel {

    private Fragment tabFragment;
    private String tabName;
    private int tabDrawable;

    public FragmentTabModel(Fragment tabFragment, String tabName, int tabDrawable) {
        this.tabFragment = tabFragment;
        this.tabName = tabName;
        this.tabDrawable = tabDrawable;
    }

    public Fragment getTabFragment() {
        return tabFragment;
    }

    public void setTabFragment(Fragment tabFragment) {
        this.tabFragment = tabFragment;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public int getTabDrawable() {
        return tabDrawable;
    }

    public void setTabDrawable(int tabDrawable) {
        this.tabDrawable = tabDrawable;
    }
}
