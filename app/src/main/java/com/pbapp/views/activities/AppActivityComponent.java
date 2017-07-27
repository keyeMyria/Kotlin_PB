package com.pbapp.views.activities;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {AppActivityModule.class})
public interface AppActivityComponent {
    void inject(AppActivity activity);
}
