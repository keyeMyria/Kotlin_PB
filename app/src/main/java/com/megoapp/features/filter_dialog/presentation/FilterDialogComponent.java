package com.megoapp.features.filter_dialog.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.filter_dialog.usecase.FilterDialogUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {FilterDialogModule.class, FilterDialogUseCaseModule.class})
public interface FilterDialogComponent {

    void inject(FilterDialogView view);

}
