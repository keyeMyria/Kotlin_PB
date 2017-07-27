package com.megoapp.features.vehicles_list.usecases;


import dagger.Module;
import dagger.Provides;

@Module
public class VehicleListUseCaseModule {

    @Provides
    public GetAvailableVehiclesByGeoHash provideGetAvailableVehiclesByGeoHash(GetAvailableVehiclesByGeoHashImpl usecase) {
        return usecase;
    }
}
