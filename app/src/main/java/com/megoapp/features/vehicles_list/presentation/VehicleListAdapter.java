package com.megoapp.features.vehicles_list.presentation;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.megoapp.R;
import com.megoapp.features.vehicles_list.modess.VehiclePresentationModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VehicleListAdapter extends RecyclerView.Adapter<ViewHolder> {


    private final List<VehiclePresentationModel> vehicles = new ArrayList<>();

    public VehicleListAdapter(List<VehiclePresentationModel> vehicles) {
        this.vehicles.clear();
        this.vehicles.addAll(vehicles);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_vehicle, parent, false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        VehiclePresentationModel vehicle = vehicles.get(position);

        ((VehicleViewHolder) holder).render(vehicle);
    }

    @Override
    public int getItemCount() {
        return this.vehicles.size();
    }

    class VehicleViewHolder extends ViewHolder {

        @BindView(R.id.item_vehicle_card_number)
        TextView tvVehcileCardNumber;
        @BindView(R.id.item_vehicle_address)
        TextView tvVehcileAddress;
        @BindView(R.id.item_vehicle_distance)
        TextView tvVehcileDistance;
        @BindView(R.id.item_vehicle_energy)
        TextView tvVehcileEnergy;

        public VehicleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void render(VehiclePresentationModel vehicle) {
            tvVehcileCardNumber.setText(vehicle.cardNumber);
            tvVehcileAddress.setText(vehicle.address);
            tvVehcileDistance.setText(vehicle.distance);
            tvVehcileEnergy.setText(vehicle.energy);

        }
    }
}
