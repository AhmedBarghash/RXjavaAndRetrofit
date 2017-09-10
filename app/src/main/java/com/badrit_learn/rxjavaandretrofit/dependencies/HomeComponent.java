package com.badrit_learn.rxjavaandretrofit.dependencies;

import com.badrit_learn.rxjavaandretrofit.ui.MainActivity;

import dagger.Component;

/**
 * Created by ahmed-osama on 10/09/17.
 */

@Component(modules = HomeModule.class)
public interface HomeComponent {
    void inJect(MainActivity activity);
}
