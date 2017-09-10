package com.badrit_learn.rxjavaandretrofit.data_manager;

import com.badrit_learn.rxjavaandretrofit.models.UserList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ahmed-osama on 10/09/17.
 */

public interface RequestInterface {

    @GET("api/")
    Observable<UserList> getUser(@Query("results") int results);
}
