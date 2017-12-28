package com.app.arunaj.marketplace_dankotuwa.presentation.navigations;


import com.app.arunaj.marketplace_dankotuwa.presentation.BaseFragment;

public class NavigationHolder {

    private static NavigationHolder sInstance;
    private BaseFragment mNavigationFragment;

    public static NavigationHolder instance() {
        if (sInstance == null) {
            sInstance = new NavigationHolder();
        }
        return sInstance;
    }

    public void holdNavigationFragment(BaseFragment navigationFragment) {
        this.mNavigationFragment = navigationFragment;
    }

    public BaseFragment getNavigationFragment() {
        BaseFragment fragmentToReturn = mNavigationFragment;
        return fragmentToReturn;
    }
}
