package com.pbapp.features.provider_dialog.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class ProviderDialogModule {

    private final ProviderDialogContract.View view;

    public ProviderDialogModule(ProviderDialogContract.View view) {
        this.view = view;
    }

    @Provides
    public ProviderDialogContract.View provideView() {
        return this.view;
    }

    @Provides
    public ProviderDialogContract.Presenter providePresenter(ProviderDialogPresenter presenter) {
        return presenter;
    }
}
