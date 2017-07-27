package com.megoapp.features.tos.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.tos.usecases.TosPresentationModule;
import com.megoapp.features.tos.usecases.TosUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {TosModule.class, TosUseCaseModule.class, TosPresentationModule.class})
public interface TosComponent {

    void inject(TosView view);

}
