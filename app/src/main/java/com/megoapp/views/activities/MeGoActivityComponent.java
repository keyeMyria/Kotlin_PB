package com.megoapp.views.activities;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {MeGoActivityModule.class})
public interface MeGoActivityComponent {
    void inject(MeGoActivity activity);
}
