package com.megoapp.features.providers.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.providers.usecases.ProviderSelectionUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {ProviderSelectionModule.class, ProviderSelectionUseCaseModule.class})
public interface ProviderSelectionComponent {

    void inject(ProviderSelectionView view);

}
