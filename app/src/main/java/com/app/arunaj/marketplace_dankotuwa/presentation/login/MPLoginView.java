package com.app.arunaj.marketplace_dankotuwa.presentation.login;

import android.view.View;
import android.widget.TextView;

import com.app.arunaj.marketplace_dankotuwa.presentation.BaseView;

public interface MPLoginView extends BaseView {
    void onLoginClick(View view);
    void onForgotPasswordClick(View view);
    void saveToken(String token, int id);
    void directToHome();
    void setLoginFailMessage(TextView textView, int msg);
    void setLoginFailMessage(TextView textView, String msg);
    void setPasswordEmpty();
    void requestForAsyncLogin();
//    String serverErrorMsg();
    void displayServerErrorToast();
}

