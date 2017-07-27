package com.megoapp.features.providers.presentation;


import com.megoapp.features.providers.usecases.GetAllAvailableProviders;
import com.megoapp.utilities.rx.RxDisposableFactory;
import com.megoapp.utilities.rx.RxDisposables;
import com.megoapp.utilities.rx.ThreadTransformer;

import javax.inject.Inject;

public final class ProviderSelectionPresenter implements ProviderSelectionContract.Presenter {

    private final ProviderSelectionContract.View view;
    private final GetAllAvailableProviders getAllAvailableProviders;
    private final ThreadTransformer threadTransformer;
    private final RxDisposableFactory factory;
    private final RxDisposables disposables;

    @Inject
    public ProviderSelectionPresenter(ProviderSelectionContract.View view,
                                      GetAllAvailableProviders getAllAvailableProviders,
                                      ThreadTransformer threadTransformer,
                                      RxDisposableFactory factory) {
        this.view = view;
        this.getAllAvailableProviders = getAllAvailableProviders;
        this.threadTransformer = threadTransformer;
        this.factory = factory;
        this.disposables = factory.get();
    }

    @Override
    public void onAttached() {

        disposables.add(getAllAvailableProviders.call()
                .compose(threadTransformer.applySchedulers())
                .subscribe(
                        providers -> {
                            view.loadProviderData(providers);
                        },
                        error -> {

                        }
                ));
    }

    @Override
    public void onDetached() {
        disposables.clear();
    }
}
