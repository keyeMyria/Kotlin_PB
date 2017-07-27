package com.pbapp.features.tos.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.tos.usecases.TosPresentationModule;
import com.pbapp.features.tos.usecases.TosUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {TosModule.class, TosUseCaseModule.class, TosPresentationModule.class})
public interface TosComponent {

    void inject(TosView view);

}
