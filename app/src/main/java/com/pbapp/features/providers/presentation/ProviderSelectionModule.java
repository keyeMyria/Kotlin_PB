package com.pbapp.features.providers.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class ProviderSelectionModule {

    private final ProviderSelectionContract.View view;

    public ProviderSelectionModule(ProviderSelectionContract.View view) {
        this.view = view;
    }

    @Provides
    public ProviderSelectionContract.View provideView() {
        return this.view;
    }

    @Provides
    public ProviderSelectionContract.Presenter providePresenter(ProviderSelectionPresenter presenter) {
        return presenter;
    }
}
