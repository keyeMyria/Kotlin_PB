package com.pbapp.features.app_about.presentation;


import com.pbapp.utilities.rx.RxDisposableFactory;
import com.pbapp.utilities.rx.RxDisposables;
import com.pbapp.utilities.rx.ThreadTransformer;

import javax.inject.Inject;

public final class AppAboutPresenter implements AppAboutContract.Presenter {

    private final AppAboutContract.View view;
    private final ThreadTransformer threadTransformer;
    private final RxDisposableFactory factory;
    private final RxDisposables disposables;

    @Inject
    public AppAboutPresenter(AppAboutContract.View view,
                             ThreadTransformer threadTransformer,
                             RxDisposableFactory factory) {
        this.view = view;
        this.threadTransformer = threadTransformer;
        this.factory = factory;
        this.disposables = factory.get();
    }

    @Override
    public void onAttached() {

    }

    @Override
    public void onDetached() {
        disposables.clear();
    }
}
