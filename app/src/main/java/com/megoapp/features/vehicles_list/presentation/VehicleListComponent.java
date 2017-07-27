package com.megoapp.features.vehicles_list.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.vehicles_list.usecases.VehicleListUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {VehicleListModule.class, VehicleListUseCaseModule.class})
public interface VehicleListComponent {

    void inject(VehicleListView view);

}
