package com.megoapp.features.vehicles_map.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class VehicleMapModule {

    private final VehicleMapContract.View view;

    public VehicleMapModule(VehicleMapContract.View view) {
        this.view = view;
    }

    @Provides
    public VehicleMapContract.View provideView() {
        return this.view;
    }

    @Provides
    public VehicleMapContract.Presenter providePresenter(VehicleMapPresenter presenter) {
        return presenter;
    }
}
