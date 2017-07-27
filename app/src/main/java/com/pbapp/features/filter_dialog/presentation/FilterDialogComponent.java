package com.pbapp.features.filter_dialog.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.filter_dialog.usecase.FilterDialogUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {FilterDialogModule.class, FilterDialogUseCaseModule.class})
public interface FilterDialogComponent {

    void inject(FilterDialogView view);

}
