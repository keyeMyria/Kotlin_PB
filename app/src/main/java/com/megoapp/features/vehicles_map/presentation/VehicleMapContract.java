package com.megoapp.features.vehicles_map.presentation;


import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;

public interface VehicleMapContract {

    interface View {

        void showFilterDialog();

        void showProviderDialog();

        void showVehicleInfoSheet();
    }

    interface Presenter {
        void onAttached();

        void onDetached();

        void onMapReady(GoogleMap googleMap);

        boolean onNavigationItemTapped(MenuItem item);

        void onToolbarMapMenuTapped();

        void onFilterDialogOKTapped();

        void onProvidersDialogOKTapped();
    }
}
