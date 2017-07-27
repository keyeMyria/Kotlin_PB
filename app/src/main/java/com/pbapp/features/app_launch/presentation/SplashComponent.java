package com.pbapp.features.app_launch.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ActivityScope;
import com.pbapp.features.app_launch.usecases.SplashUseCaseModule;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {SplashModule.class, SplashUseCaseModule.class})
public interface SplashComponent {

    void inject(SplashActivity splashActivity);

}
