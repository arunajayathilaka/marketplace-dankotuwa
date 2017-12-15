package com.app.arunaj.marketplace_dankotuwa.models;

import com.google.gson.Gson;

/**
 * Created by arunaj on 12/15/17.
 */

public class BaseModel {
    public static String asModel(BaseModel baseModel) {
        final Gson gson = new Gson();
        return gson.toJson(baseModel);
    }
}
