package com.badrit_learn.rxjavaandretrofit.view;

import com.badrit_learn.rxjavaandretrofit.models.Result;

import java.util.ArrayList;

/**
 * Created by ahmed-osama on 10/09/17.
 */

public interface HomeView {
    void showLoading();
    void hideLoading();
    void onConnectionError();
    void showMessage(String Message);
    void FillUsersList(ArrayList<Result> users);
}
