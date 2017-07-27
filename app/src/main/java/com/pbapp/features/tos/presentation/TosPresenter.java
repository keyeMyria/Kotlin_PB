package com.pbapp.features.tos.presentation;


import com.pbapp.features.tos.usecases.LoadTos;
import com.pbapp.utilities.rx.RxDisposableFactory;
import com.pbapp.utilities.rx.RxDisposables;
import com.pbapp.utilities.rx.ThreadTransformer;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;

import static io.reactivex.Single.just;

public final class TosPresenter implements TosContract.Presenter {

    private final TosContract.View view;
    private LoadTos loadTOS;
    private final ThreadTransformer threadTransformer;
    private final RxDisposableFactory factory;
    private final RxDisposables disposables;

    @Inject
    public TosPresenter(TosContract.View view,
                        LoadTos loadTOS,
                        ThreadTransformer threadTransformer,
                        RxDisposableFactory factory) {
        this.view = view;
        this.loadTOS = loadTOS;
        this.threadTransformer = threadTransformer;
        this.factory = factory;
        this.disposables = factory.get();
    }

    @Override
    public void onAttached() {
        view.showLoading();
        Single.timer(1500, TimeUnit.MILLISECONDS)
                .flatMap(delay -> just((loadTOS.call())))
                .compose(threadTransformer.applySchedulers())
                .subscribe(loadedTos -> {
                    view.showTos(loadedTos);
                });
    }


    @Override
    public void onDetached() {
        disposables.clear();
    }
}
