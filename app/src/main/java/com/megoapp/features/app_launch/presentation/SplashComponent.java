package com.megoapp.features.app_launch.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ActivityScope;
import com.megoapp.features.app_launch.usecases.SplashUseCaseModule;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {SplashModule.class, SplashUseCaseModule.class})
public interface SplashComponent {

    void inject(SplashActivity splashActivity);

}
