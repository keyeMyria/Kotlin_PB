package com.megoapp.features.tos.usecases;


import dagger.Module;
import dagger.Provides;

@Module
public class TosUseCaseModule {
    @Provides
    public LoadTos provideLoadTos(LoadTosImpl usecase) {
        return usecase;
    }
}
