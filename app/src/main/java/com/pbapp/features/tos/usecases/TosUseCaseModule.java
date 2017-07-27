package com.pbapp.features.tos.usecases;


import dagger.Module;
import dagger.Provides;

@Module
public class TosUseCaseModule {
    @Provides
    public LoadTos provideLoadTos(LoadTosImpl usecase) {
        return usecase;
    }
}
