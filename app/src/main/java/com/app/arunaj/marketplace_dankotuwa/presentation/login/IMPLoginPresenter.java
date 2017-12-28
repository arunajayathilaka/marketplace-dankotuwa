package com.app.arunaj.marketplace_dankotuwa.presentation.login;


import com.app.arunaj.marketplace_dankotuwa.presentation.BasePresenter;
import com.app.arunaj.marketplace_dankotuwa.presentation.BaseView;


public interface IMPLoginPresenter<V extends BaseView> extends BasePresenter<V> {
    public void verifyLogin(String email, String password);
    public void onFinishAsynLoginCall();
}
