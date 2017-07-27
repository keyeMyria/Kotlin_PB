package com.megoapp.features.vehicles_list.presentation;


import com.megoapp.features.vehicles_list.usecases.GetAvailableVehiclesByGeoHash;
import com.megoapp.utilities.rx.RxDisposableFactory;
import com.megoapp.utilities.rx.RxDisposables;
import com.megoapp.utilities.rx.ThreadTransformer;

import javax.inject.Inject;

public final class VehicleListPresenter implements VehicleListContract.Presenter {

    private final VehicleListContract.View view;
    private final GetAvailableVehiclesByGeoHash getAvailableVehiclesByGeoHash;
    private final ThreadTransformer threadTransformer;
    private final RxDisposableFactory factory;
    private final RxDisposables disposables;

    @Inject
    public VehicleListPresenter(VehicleListContract.View view,
                                GetAvailableVehiclesByGeoHash getAvailableVehiclesByGeoHash,
                                ThreadTransformer threadTransformer,
                                RxDisposableFactory factory) {

        this.view = view;
        this.getAvailableVehiclesByGeoHash = getAvailableVehiclesByGeoHash;
        this.threadTransformer = threadTransformer;
        this.factory = factory;
        this.disposables = factory.get();
    }

    @Override
    public void onAttached() {

        disposables.add(getAvailableVehiclesByGeoHash.call()
                .compose(threadTransformer.applySchedulers())
                .subscribe(vehicles -> {
                            view.bindDataToList(vehicles);
                        },
                        e -> {
                        }));

    }

    @Override
    public void onDetached() {
        disposables.clear();
    }
}
