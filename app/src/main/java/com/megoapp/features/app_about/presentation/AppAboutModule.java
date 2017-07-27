package com.megoapp.features.app_about.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class AppAboutModule {

    private final AppAboutContract.View view;

    public AppAboutModule(AppAboutContract.View view) {
        this.view = view;
    }

    @Provides
    public AppAboutContract.View provideView() {
        return this.view;
    }

    @Provides
    public AppAboutContract.Presenter providePresenter(AppAboutPresenter presenter) {
        return presenter;
    }
}
