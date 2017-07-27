package com.megoapp.features.provider_dialog.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.provider_dialog.usecase.ProviderDialogUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {ProviderDialogModule.class, ProviderDialogUseCaseModule.class})
public interface ProviderDialogComponent {

    void inject(ProviderDialogView view);

}
