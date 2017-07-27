package com.pbapp.features.vehicles_list.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.vehicles_list.usecases.VehicleListUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {VehicleListModule.class, VehicleListUseCaseModule.class})
public interface VehicleListComponent {

    void inject(VehicleListView view);

}
