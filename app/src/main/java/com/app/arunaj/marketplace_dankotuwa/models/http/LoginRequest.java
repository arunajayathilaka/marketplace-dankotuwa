package com.app.arunaj.marketplace_dankotuwa.models.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by imalkariyawasam on 8/28/17.
 */

public class LoginRequest {
    @SerializedName("username")
    @Expose
    private String mUsername;
    @SerializedName("password")
    @Expose
    private String mPassword;

    public LoginRequest(String username, String password) {
        this.mUsername = username;
        this.mPassword = password;
    }
}
