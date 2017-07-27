package com.megoapp.features.vehicles_map.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.vehicles_map.usecases.VehicleMapUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {VehicleMapModule.class, VehicleMapUseCaseModule.class})
public interface VehicleMapComponent {

    void inject(VehicleMapView view);

}
