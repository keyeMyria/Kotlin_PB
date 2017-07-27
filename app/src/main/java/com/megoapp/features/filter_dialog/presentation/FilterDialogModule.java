package com.megoapp.features.filter_dialog.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class FilterDialogModule {

    private final FilterDialogContract.View view;

    public FilterDialogModule(FilterDialogContract.View view) {
        this.view = view;
    }

    @Provides
    public FilterDialogContract.View provideView() {
        return this.view;
    }

    @Provides
    public FilterDialogContract.Presenter providePresenter(FilterDialogPresenter presenter) {
        return presenter;
    }
}
