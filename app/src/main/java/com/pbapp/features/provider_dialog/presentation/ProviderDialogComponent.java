package com.pbapp.features.provider_dialog.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.provider_dialog.usecase.ProviderDialogUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {ProviderDialogModule.class, ProviderDialogUseCaseModule.class})
public interface ProviderDialogComponent {

    void inject(ProviderDialogView view);

}
