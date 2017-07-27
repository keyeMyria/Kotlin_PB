package com.pbapp.features.trips.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.providers.usecases.ProviderSelectionUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {TripListModule.class, ProviderSelectionUseCaseModule.class})
public interface TripListComponent {

    void inject(TripListView splashActivity);

}
