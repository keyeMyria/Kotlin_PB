package com.megoapp.features.app_launch.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    private final SplashContract.View view;

    public SplashModule(SplashContract.View view) {
        this.view = view;
    }

    @Provides
    public SplashContract.View provideView() {
        return this.view;
    }

    @Provides
    public SplashContract.Presenter providePresenter(SplashPresenter presenter) {
        return presenter;
    }
}
