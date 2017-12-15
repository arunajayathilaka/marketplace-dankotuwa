package com.app.arunaj.marketplace_dankotuwa.data.rest;

import android.util.Log;

import com.app.arunaj.marketplace_dankotuwa.data.rest.retrofit.ApiRetrofitClient;

/**
 * Created by arunaj on 12/15/17.
 */

public class ApiFactory {
    private final static Class RETROFIT_CLIENT = ApiRetrofitClient.class;
    private final static Class apiClass = RETROFIT_CLIENT;
    private static ApiClient mApiClient;

    public static ApiClient getApiClient() {
        try {
            if (mApiClient == null) {
                Log.d("apiclient", "new");
                mApiClient = (ApiClient) apiClass.newInstance();
            }
            return mApiClient;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
