package com.megoapp.features.app_launch.usecases;

import dagger.Module;
import dagger.Provides;


@Module
public class SplashUseCaseModule {
    @Provides
    public GetCurrentLocation provideGetCurrentLocation(GetCurrentLocationImpl usecase) {
        return usecase;
    }

    @Provides
    public SaveCurrentCity provideSaveCurrentCity(SaveCurrentCityImpl usecase) {
        return usecase;
    }

    @Provides
    public FetchFeedEntries provideFetchFeedEntries(FetchFeedEntriesImpl usecase) {
        return usecase;
    }

}
