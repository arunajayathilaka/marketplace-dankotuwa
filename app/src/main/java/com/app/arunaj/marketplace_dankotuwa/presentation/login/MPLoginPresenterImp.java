package com.app.arunaj.marketplace_dankotuwa.presentation.login;

import com.app.arunaj.marketplace_dankotuwa.data.rest.ApiClient;
import com.app.arunaj.marketplace_dankotuwa.data.rest.ApiFactory;
import com.app.arunaj.marketplace_dankotuwa.models.http.LoginRequest;
import com.app.arunaj.marketplace_dankotuwa.models.http.LoginResponse;


public class MPLoginPresenterImp implements IMPLoginPresenter<MPLoginView> {

    private MPLoginView mMPLoginView;
    private ApiClient mApiClient;
    private LoginResponse mLoginResponse;

    @Override
    public void verifyLogin(String email, String password) {
        this.mApiClient = ApiFactory.getLoginApiClient();
        LoginRequest loginRequest = new LoginRequest(email, password);
        //mLoginResponse = mApiClient.verifyLogin(loginRequest);
    }

    @Override
    public void onFinishAsynLoginCall() {
        if (mLoginResponse != null) {
            Boolean success = mLoginResponse.getSuccess();
            mMPLoginView.dismissProgress();
            if (success) {
               /* Data sessionData = mLoginResponse.getData();
                String token = Constants.AUTHORIZATION_BEARER + sessionData.getToken();
                int userId = (int)mLoginResponse.getUserId();
                mMPLoginView.saveToken(token, userId);
                mMPLoginView.directToHome();*/
            } else {
                    mMPLoginView.setPasswordEmpty();
                    String msg = mLoginResponse.getMsg();
                    mMPLoginView.setLoginFailMessage(null, msg);
            }
        } else {
            mMPLoginView.dismissProgress();
            //mMPLoginView.displayToast(mMPLoginView.serverErrorMsg());
            mMPLoginView.displayServerErrorToast();
        }
    }

    @Override
    public void onAttached(MPLoginView MPLoginView) {
        mMPLoginView = MPLoginView;
    }

    public void setApiClient(ApiClient apiClient) {
        this.mApiClient = apiClient;
    }

    public LoginResponse getLoginResponse() {
        return mLoginResponse;
    }

    public void setLoginResponse(LoginResponse loginResponse) {
        this.mLoginResponse = loginResponse;
    }

    @Override
    public void onDestroy() {

    }
}
