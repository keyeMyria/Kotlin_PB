package com.megoapp.features.vehicles_map.presentation;

import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.megoapp.R;
import com.megoapp.features.events.OpenViewEvent;
import com.megoapp.features.events.ViewAppBarEvent;
import com.megoapp.utilities.StringUtils;
import com.megoapp.utilities.rx.RxDisposableFactory;
import com.megoapp.utilities.rx.RxDisposables;
import com.megoapp.utilities.rx.ThreadTransformer;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

public final class VehicleMapPresenter implements VehicleMapContract.Presenter {

    private static final LatLng BERLIN = new LatLng(52.5200, 13.4050);
    private final VehicleMapContract.View view;
    private final EventBus bus;
    private final StringUtils stringUtils;
    private final ThreadTransformer threadTransformer;
    private final RxDisposableFactory rxDisposableFactory;
    private final RxDisposables disposables;

    @Inject
    public VehicleMapPresenter(VehicleMapContract.View view,
                               EventBus bus,
                               StringUtils stringUtils,
                               ThreadTransformer threadTransformer,
                               RxDisposableFactory rxDisposableFactory) {
        this.view = view;
        this.bus = bus;
        this.stringUtils = stringUtils;
        this.threadTransformer = threadTransformer;
        this.disposables = rxDisposableFactory.get();
        this.rxDisposableFactory = rxDisposableFactory;
    }


    @Override
    public void onAttached() {

    }

    @Override
    public void onDetached() {
        disposables.clear();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.addMarker(new MarkerOptions()
                .position(BERLIN)
                .title("Marker in Berlin")
        );

        googleMap.setOnMarkerClickListener(marker -> {
            if (BERLIN.equals(marker.getPosition())) {
                view.showVehicleInfoSheet();
            }
            return true;
        });

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BERLIN, 18));
    }

    @Override
    public boolean onNavigationItemTapped(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_bottom_navigation_list:
                bus.post(new OpenViewEvent(OpenViewEvent.ViewTag.VEHICLE_LIST));
                return true;

            case R.id.item_bottom_navigation_filter:
                view.showFilterDialog();
                return true;

            case R.id.item_bottom_navigation_provider:
                view.showProviderDialog();
                return true;
        }

        return true;
    }

    @Override
    public void onToolbarMapMenuTapped() {
        bus.post(new ViewAppBarEvent());
    }

    @Override
    public void onFilterDialogOKTapped() {

    }

    @Override
    public void onProvidersDialogOKTapped() {

    }

}
