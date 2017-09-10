package com.badrit_learn.rxjavaandretrofit.interactour;

import com.badrit_learn.rxjavaandretrofit.data_manager.RequestInterface;
import com.badrit_learn.rxjavaandretrofit.interfaces.OnReceiveResultListener;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ahmed-osama on 10/09/17.
 */

public class HomeInteractor {


    public static final String BASE_URL = "https://randomuser.me/";
    public static final int NUMBER_OF_USERS = 100;

    public HomeInteractor() {

    }

    public void getList(OnReceiveResultListener callBack) {
        RequestInterface retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface.class);

        retrofit.getUser(NUMBER_OF_USERS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(callBack::onSuccess, callBack::onFailure);
    }
}
