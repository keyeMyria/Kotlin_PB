package com.megoapp.features.provider_dialog.presentation;


import com.megoapp.features.provider_dialog.usecase.GetProviders;
import com.megoapp.utilities.rx.RxDisposableFactory;
import com.megoapp.utilities.rx.RxDisposables;
import com.megoapp.utilities.rx.ThreadTransformer;

import javax.inject.Inject;

public final class ProviderDialogPresenter implements ProviderDialogContract.Presenter {

    private final ProviderDialogContract.View view;
    private GetProviders getProviders;
    private final ThreadTransformer threadTransformer;
    private final RxDisposableFactory factory;
    private final RxDisposables disposables;

    @Inject
    public ProviderDialogPresenter(ProviderDialogContract.View view,
                                   GetProviders getProviders,
                                   ThreadTransformer threadTransformer,
                                   RxDisposableFactory factory) {
        this.view = view;
        this.getProviders = getProviders;
        this.threadTransformer = threadTransformer;
        this.factory = factory;
        this.disposables = factory.get();
    }

    @Override
    public void onAttached() {

        disposables.add(getProviders.call()
                .compose(threadTransformer.applySchedulers())
                .subscribe(
                        providers -> {
                            view.loadProviders(providers);
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
