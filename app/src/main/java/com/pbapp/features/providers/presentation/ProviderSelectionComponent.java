package com.pbapp.features.providers.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.providers.usecases.ProviderSelectionUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {ProviderSelectionModule.class, ProviderSelectionUseCaseModule.class})
public interface ProviderSelectionComponent {

    void inject(ProviderSelectionView view);

}
