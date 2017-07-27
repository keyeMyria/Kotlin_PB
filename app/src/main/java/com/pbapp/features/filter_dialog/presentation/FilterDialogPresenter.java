package com.pbapp.features.filter_dialog.presentation;


import com.pbapp.features.filter_dialog.usecase.GetFilters;
import com.pbapp.utilities.rx.RxDisposableFactory;
import com.pbapp.utilities.rx.RxDisposables;
import com.pbapp.utilities.rx.ThreadTransformer;

import javax.inject.Inject;

public final class FilterDialogPresenter implements FilterDialogContract.Presenter {

    private final FilterDialogContract.View view;
    private GetFilters getFilters;
    private final ThreadTransformer threadTransformer;
    private final RxDisposableFactory factory;
    private final RxDisposables disposables;

    @Inject
    public FilterDialogPresenter(FilterDialogContract.View view,
                                 GetFilters getFilters,
                                 ThreadTransformer threadTransformer,
                                 RxDisposableFactory factory) {
        this.view = view;
        this.getFilters = getFilters;
        this.threadTransformer = threadTransformer;
        this.factory = factory;
        this.disposables = factory.get();
    }

    @Override
    public void onAttached() {

        disposables.add(getFilters.call()
                .compose(threadTransformer.applySchedulers())
                .subscribe(
                        providers -> {
                            view.loadFilters(providers);
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
