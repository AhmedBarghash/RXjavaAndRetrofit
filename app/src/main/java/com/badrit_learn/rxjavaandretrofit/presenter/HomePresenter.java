package com.badrit_learn.rxjavaandretrofit.presenter;

import android.util.Log;

import com.badrit_learn.rxjavaandretrofit.interactour.HomeInteractor;
import com.badrit_learn.rxjavaandretrofit.interfaces.OnReceiveResultListener;
import com.badrit_learn.rxjavaandretrofit.models.UserList;
import com.badrit_learn.rxjavaandretrofit.view.HomeView;

import javax.inject.Inject;

/**
 * Created by ahmed-osama on 10/09/17.
 */

public class HomePresenter implements OnReceiveResultListener {

    private HomeView mView;
    private HomeInteractor mInteractor;

    @Inject
    public HomePresenter(HomeView view, HomeInteractor interactor) {
        this.mView = view;
        this.mInteractor = interactor;
    }

    public void getUsersList() {
        mView.showLoading();
        mInteractor.getList(this);
    }

    @Override
    public void onSuccess(UserList userLists) {
        mView.hideLoading();
        mView.FillUsersList(userLists.getResults());
    }

    @Override
    public void onFailure(Throwable error) {
        Log.i("Hello",error.getMessage().toString());
        mView.showMessage(error.getMessage().toString());
    }
}
