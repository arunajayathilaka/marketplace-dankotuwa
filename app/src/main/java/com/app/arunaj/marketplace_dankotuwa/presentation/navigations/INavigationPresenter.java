package com.app.arunaj.marketplace_dankotuwa.presentation.navigations;


import com.app.arunaj.marketplace_dankotuwa.data.rest.ApiClient;
import com.app.arunaj.marketplace_dankotuwa.presentation.BasePresenter;
import com.app.arunaj.marketplace_dankotuwa.presentation.BaseView;

public interface INavigationPresenter<V extends BaseView> extends BasePresenter<V> {
    void getData(int id);
    void passData();
    String getProfilePic();
    String getUsername();
    void setApiClient(ApiClient apiClient);
    void setProfilePic(String profilepic);
    void setUsername(String username);
}
