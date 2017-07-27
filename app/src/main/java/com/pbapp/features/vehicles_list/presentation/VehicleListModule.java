package com.pbapp.features.vehicles_list.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class VehicleListModule {

    private final VehicleListContract.View view;

    public VehicleListModule(VehicleListContract.View view) {
        this.view = view;
    }

    @Provides
    public VehicleListContract.View provideView() {
        return this.view;
    }

    @Provides
    public VehicleListContract.Presenter providePresenter(VehicleListPresenter presenter) {
        return presenter;
    }
}
