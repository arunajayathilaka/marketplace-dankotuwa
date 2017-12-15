package com.app.arunaj.marketplace_dankotuwa.presentation;

/**
 * Created by arunaj on 12/15/17.
 */

public interface BaseView {
    void setPresenter(BasePresenter presenter);
    void showProgress();
    void hideProgress();
}
