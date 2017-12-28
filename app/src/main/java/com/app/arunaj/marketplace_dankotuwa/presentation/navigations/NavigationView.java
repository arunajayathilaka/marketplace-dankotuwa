package com.app.arunaj.marketplace_dankotuwa.presentation.navigations;


import com.app.arunaj.marketplace_dankotuwa.presentation.BaseView;

public interface NavigationView extends BaseView {
    void setUserName(String userName);
    void setProPic(String pic);
    void setProfilePic(String mProfilepic);
    void setUsername(String mUsername);
    void logout();
    void displayServerErrorToast();
    void displaySessionExpired();
}
