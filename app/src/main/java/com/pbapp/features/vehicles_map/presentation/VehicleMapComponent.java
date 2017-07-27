package com.pbapp.features.vehicles_map.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.vehicles_map.usecases.VehicleMapUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {VehicleMapModule.class, VehicleMapUseCaseModule.class})
public interface VehicleMapComponent {

    void inject(VehicleMapView view);

}
