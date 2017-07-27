package com.megoapp.features.trips.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.providers.usecases.ProviderSelectionUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {TripListModule.class, ProviderSelectionUseCaseModule.class})
public interface TripListComponent {

    void inject(TripListView splashActivity);

}
