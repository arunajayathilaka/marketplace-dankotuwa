package com.app.arunaj.marketplace_dankotuwa.presentation;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.app.arunaj.marketplace_dankotuwa.R;

public class BaseFragment extends Fragment {
    public void pushFragment(BaseFragment baseFragment) {
        ((BaseActivity)getActivity()).pushFragment(baseFragment);
    }

    public void displayToast(String msg){
        Activity activity = getActivity();
        if (activity != null) {
            Toast.makeText(activity.getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

    public void displayServerErrorToast() {
        String msg = getResources().getString(R.string.error_response_null);
        displayToast(msg);
    }

    public void displaySessionExpired() {
        String msg = getResources().getString(R.string.error_session_expired);
        displayToast(msg);
    }
}
