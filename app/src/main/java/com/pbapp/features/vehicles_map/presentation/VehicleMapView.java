package com.pbapp.features.vehicles_map.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.maps.SupportMapFragment;
import com.pbapp.App;
import com.pbapp.AppComponent;
import com.pbapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class VehicleMapView extends Fragment implements VehicleMapContract.View {


    @Inject
    VehicleMapContract.Presenter presenter;

    @BindView(R.id.map_bottom_navigation)
    BottomNavigationView mapBottomNavigation;

    @BindView(R.id.map_bottom_sheet)
    View vMapBottomSheet;

    @BindView(R.id.fab_map_bottom_sheet)
    FloatingActionButton fabBottomSheet;

    private VehicleMapComponent scopeGraph;
    private Unbinder unbinder;
    private MaterialDialog filterDialog;
    private MaterialDialog providerDialog;
    private BottomSheetBehavior behavior;

    public static VehicleMapView getInstance() {
        return new VehicleMapView();
    }

    @OnClick(R.id.img_tb_map_menu)
    public void onToolbarMapMenuClicked() {
        presenter.onToolbarMapMenuTapped();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        setupScopeGraph(App.get(getActivity()).getAppComponent());
        unbinder = ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onAttached();
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.map_container, mapFragment)
                .commit();
        mapFragment.getMapAsync(googleMap -> presenter.onMapReady(googleMap));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDetached();
        unbinder.unbind();
    }

    @Override
    public void showFilterDialog() {
        if (filterDialog != null) {
            filterDialog.show();
        }
    }

    @Override
    public void showProviderDialog() {
        if (providerDialog != null) {
            providerDialog.show();
        }
    }


    @Override
    public void showVehicleInfoSheet() {
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    private void initViews() {
        filterDialog = new MaterialDialog.Builder(getActivity())
                .customView(R.layout.dialog_filter, true)
                .title(R.string.dialog_filter_title)
                .titleColor(getResources().getColor(R.color.colorPrimary))
                .positiveText(R.string.ok)
                .onPositive((dialog, action) -> presenter.onFilterDialogOKTapped())
                .positiveColor(getResources().getColor(R.color.colorPrimary))
                .cancelable(true)
                .build();

        providerDialog = new MaterialDialog.Builder(getActivity())
                .customView(R.layout.dialog_provider, true)
                .title(R.string.dialog_provider_title)
                .titleColor(getResources().getColor(R.color.colorPrimary))
                .positiveText(R.string.ok)
                .onPositive((dialog, action) -> presenter.onProvidersDialogOKTapped())
                .positiveColor(getResources().getColor(R.color.colorPrimary))
                .cancelable(true)
                .build();

        mapBottomNavigation.setOnNavigationItemSelectedListener(item -> presenter.onNavigationItemTapped(item));

        behavior = BottomSheetBehavior.from(vMapBottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_DRAGGING");
                        fabBottomSheet.setVisibility(View.VISIBLE);
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_SETTLING");
                        fabBottomSheet.setVisibility(View.VISIBLE);
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_EXPANDED");
                        fabBottomSheet.setVisibility(View.GONE);
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_COLLAPSED");
                        fabBottomSheet.setVisibility(View.VISIBLE);
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_HIDDEN");
                        fabBottomSheet.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }


    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerVehicleMapComponent.builder()
                .appComponent(appComponent)
                .vehicleMapModule(new VehicleMapModule(this))
                .build();
        scopeGraph.inject(this);
    }

}
