package com.pbapp.features.trips.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class TripListModule {

    private final TripListContract.View view;

    public TripListModule(TripListContract.View view) {
        this.view = view;
    }

    @Provides
    public TripListContract.View provideView() {
        return this.view;
    }

    @Provides
    public TripListContract.Presenter providePresenter(TripListPresenter presenter) {
        return presenter;
    }
}
