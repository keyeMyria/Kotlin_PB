package com.pbapp.features.tos.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class TosModule {

    private final TosContract.View view;

    public TosModule(TosContract.View view) {
        this.view = view;
    }

    @Provides
    public TosContract.View provideView() {
        return this.view;
    }

    @Provides
    public TosContract.Presenter providePresenter(TosPresenter presenter) {
        return presenter;
    }

}
