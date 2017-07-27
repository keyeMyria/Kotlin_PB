package com.pbapp.features.providers.usecases;


import dagger.Module;
import dagger.Provides;

@Module
public class ProviderSelectionUseCaseModule {


    @Provides
    public GetAllAvailableProviders provideGetAllAvailableProviders(GetAllAvailableProvidersImpl usecase) {
        return usecase;
    }
}
