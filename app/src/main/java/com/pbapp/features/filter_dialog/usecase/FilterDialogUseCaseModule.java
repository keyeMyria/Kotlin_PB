package com.pbapp.features.filter_dialog.usecase;


import dagger.Module;
import dagger.Provides;

@Module
public class FilterDialogUseCaseModule {

    @Provides
    public GetFilters provideGetFilters(GetFiltersImpl usecase) {
        return usecase;
    }
}
