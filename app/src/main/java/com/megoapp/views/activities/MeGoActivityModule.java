package com.megoapp.views.activities;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.megoapp.di.scope.ActivityScope;
import com.megoapp.utilities.navigation.AppNavigator;
import com.megoapp.utilities.navigation.impl.AppNavigatorImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MeGoActivityModule {

    private final MeGoActivityContract.View view;

    public MeGoActivityModule(MeGoActivityContract.View view) {
        this.view = view;
    }

    @Provides
    public MeGoActivityContract.View provideView() {
        return this.view;
    }

    @Provides
    public MeGoActivityContract.Presenter providePresenter(MeGoActivityPresenter presenter) {
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
