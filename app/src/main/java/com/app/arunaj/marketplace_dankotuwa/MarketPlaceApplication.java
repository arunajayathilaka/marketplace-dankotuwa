package com.app.arunaj.marketplace_dankotuwa;

import android.app.Application;
import android.content.Context;

import com.orm.SugarContext;

/**
 * Created by arunaj on 12/14/17.
 */

public class MarketPlaceApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SugarContext.init(mContext);
    }

    public static Context getContext() {
        return mContext;
    }

}
