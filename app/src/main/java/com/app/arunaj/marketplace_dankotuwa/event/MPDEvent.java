package com.app.arunaj.marketplace_dankotuwa.event;

import com.app.arunaj.marketplace_dankotuwa.models.BaseModel;

/**
 * Created by arunaj on 12/15/17.
 */

public class MPDEvent<T extends BaseModel> {
    public static MPDEvent newInstance() {
        return new MPDEvent();
    }

    private T entity;

    private String tag;

    public Integer objectId = 0;

    public boolean isInitialCall = false;

    public MPDEvent(T tEntity) {
        this.entity = tEntity;
    }

    public MPDEvent() {

    }

    public T getEntity() {
        return entity;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
