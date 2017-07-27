package com.megoapp.features.app_about.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.app_about.usecases.AppAboutUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {AppAboutModule.class, AppAboutUseCaseModule.class})
public interface AppAboutComponent {

    void inject(AppAboutView view);

}
