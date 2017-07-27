package com.megoapp.features.provider_dialog.usecase;


import dagger.Module;
import dagger.Provides;

@Module
public class ProviderDialogUseCaseModule {

    @Provides
    public GetProviders provideGetFilters(GetProvidersImpl usecase) {
        return usecase;
    }
}
