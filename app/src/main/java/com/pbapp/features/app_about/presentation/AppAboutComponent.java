package com.pbapp.features.app_about.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.app_about.usecases.AppAboutUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {AppAboutModule.class, AppAboutUseCaseModule.class})
public interface AppAboutComponent {

    void inject(AppAboutView view);

}
