package com.app.arunaj.marketplace_dankotuwa.presentation.navigations;


import com.app.arunaj.marketplace_dankotuwa.data.rest.ApiClient;
import com.app.arunaj.marketplace_dankotuwa.data.rest.ApiFactory;

public class NavigationPresenterImp implements INavigationPresenter<NavigationView> {

    private NavigationView mNavigationView;
    private ApiClient mApiClient;
    private String mProfilePic;
    private String mUserName;

    public NavigationPresenterImp() {
        mApiClient = ApiFactory.getApiClient();
    }

    @Override
    public void onAttached(NavigationView navigationView) {
        this.mNavigationView = navigationView;
    }

    @Override
    public void onDestroy() {

    }

    public void getData(int id) {
       /* mUserResponse = mApiClient.getUser(id);
        if (mUserResponse != null) {
            mProfilePic = mUserResponse.getUser().getProfilePic();
            mUserName = mUserResponse.getUser().getUsername();
        }*/
    }

    public void passData() {
       /* if (mUserResponse != null) {
            mNavigationView.setProfilePic(mProfilePic);
            mNavigationView.setProPic(mProfilePic);
            mNavigationView.setUsername(mUserName);
            mNavigationView.setUserName(mUserName);
        } else {
            if (mApiClient.getExceptionMessage().equals("token expired")) {
                mNavigationView.displaySessionExpired();
                mNavigationView.logout();
            } else {
                mNavigationView.displayServerErrorToast();
            }
        }*/
    }

    public String getProfilePic() {
        return mProfilePic;
    }

    public String getUsername() {
        return mUserName;
    }

    public void setApiClient(ApiClient apiClient) {
        this.mApiClient = apiClient;
    }

    public void setProfilePic(String profilepic) {
        this.mProfilePic = profilepic;
    }

    public void setUsername(String username) {
        this.mUserName = username;
    }

}
