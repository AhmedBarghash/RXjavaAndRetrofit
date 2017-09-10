package com.badrit_learn.rxjavaandretrofit.interfaces;

import com.badrit_learn.rxjavaandretrofit.models.UserList;

/**
 * Created by ahmed-osama on 10/09/17.
 */

public interface OnReceiveResultListener {
    void onSuccess(UserList userLists);

    void onFailure(Throwable error);
}
