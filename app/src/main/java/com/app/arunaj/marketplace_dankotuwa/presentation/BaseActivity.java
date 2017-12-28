package com.app.arunaj.marketplace_dankotuwa.presentation;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.app.arunaj.marketplace_dankotuwa.R;
import com.app.arunaj.marketplace_dankotuwa.presentation.navigations.BackNavigationActivity;
import com.app.arunaj.marketplace_dankotuwa.presentation.navigations.NavigationHolder;

public class BaseActivity extends AppCompatActivity {

    public void pushFragment(BaseFragment baseFragment) {
        NavigationHolder.instance().holdNavigationFragment(baseFragment);
        Intent intent = new Intent(this, BackNavigationActivity.class);
        startActivity(intent);
    }

    public void displayToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void displayServerErrorToast() {
        String msg = getResources().getString(R.string.error_response_null);
        displayToast(msg);
    }

    public void displaySessionExpired() {
        String msg = getResources().getString(R.string.error_session_expired);
        displayToast(msg);
    }

    public void loadNavigatedFragment() {
        BaseFragment baseFragment = NavigationHolder.instance().getNavigationFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.back_content_frame, baseFragment);
        fragmentTransaction.commit();
    }

    public void loadFragment (Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }
}
