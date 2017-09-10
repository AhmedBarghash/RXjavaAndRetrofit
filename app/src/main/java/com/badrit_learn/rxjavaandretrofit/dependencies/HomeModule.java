package com.badrit_learn.rxjavaandretrofit.dependencies;

import com.badrit_learn.rxjavaandretrofit.interactour.HomeInteractor;
import com.badrit_learn.rxjavaandretrofit.presenter.HomePresenter;
import com.badrit_learn.rxjavaandretrofit.view.HomeView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ahmed-osama on 10/09/17.
 */

@Module
public class HomeModule {

    private HomeView homeView;

    public HomeModule(HomeView homeView) {
        this.homeView = homeView;
    }

    @Provides
    public HomeInteractor providesHomeInteractour()
    {
        return new HomeInteractor();
    }

    @Provides
    public HomePresenter providesHomePresenter(HomeInteractor Interactor) {
        return new HomePresenter(homeView,Interactor);
    }
}
