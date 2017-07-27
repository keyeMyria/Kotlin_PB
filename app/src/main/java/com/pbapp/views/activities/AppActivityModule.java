package com.pbapp.views.activities;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.pbapp.di.scope.ActivityScope;
import com.pbapp.utilities.navigation.AppNavigator;
import com.pbapp.utilities.navigation.impl.AppNavigatorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class AppActivityModule {

    private final AppActivityContract.View view;

    public AppActivityModule(AppActivityContract.View view) {
        this.view = view;
    }

    @Provides
    public AppActivityContract.View provideView() {
        return this.view;
    }

    @Provides
    public AppActivityContract.Presenter providePresenter(AppActivityPresenter presenter) {
        return presenter;
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return ((AppCompatActivity) view).getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    AppNavigator provideAppNavigator(AppNavigatorImpl navigator) {
        return navigator;
    }
}
