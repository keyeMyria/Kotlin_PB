package com.pbapp.features.vehicles_list.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pbapp.App;
import com.pbapp.AppComponent;
import com.pbapp.R;
import com.pbapp.features.vehicles_list.modess.VehiclePresentationModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VehicleListView extends Fragment implements VehicleListContract.View {

    @Inject
    VehicleListContract.Presenter presenter;

    @BindView(R.id.ls_vehicles)
    RecyclerView lsVehicles;

    private VehicleListComponent scopeGraph;
    private Unbinder unbinder;

    public static VehicleListView getInstance() {
        return new VehicleListView();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicle_list, container, false);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDetached();
        unbinder.unbind();
    }

    @Override
    public void bindDataToList(List<VehiclePresentationModel> vehicles) {
        VehicleListAdapter adapter = new VehicleListAdapter(vehicles);
        lsVehicles.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private void initViews() {
        lsVehicles.setLayoutManager(new LinearLayoutManager(getActivity()));
        lsVehicles.setHasFixedSize(true);
    }


    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerVehicleListComponent.builder()
                .appComponent(appComponent)
                .vehicleListModule(new VehicleListModule(this))
                .build();
        scopeGraph.inject(this);
    }
}
