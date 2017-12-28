package com.app.arunaj.marketplace_dankotuwa.models.http;

/**
 * Created by imalkariyawasam on 8/28/17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("success")
    @Expose
    private Boolean mSuccess;

    @SerializedName("userId")
    @Expose
    private Integer mUserId;
    @SerializedName("msg")
    @Expose
    private String mMsg;

    public LoginResponse(Boolean success, Integer userId, String msg) {
        this.mSuccess = success;
        this.mUserId = userId;
        this.mMsg = msg;
    }

    public Boolean getSuccess() {
        return mSuccess;
    }

    public Integer getUserId() {
        return mUserId;
    }

    public String getMsg() {
        return mMsg;
    }
}