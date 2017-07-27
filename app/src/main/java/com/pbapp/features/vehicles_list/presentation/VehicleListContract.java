package com.pbapp.features.vehicles_list.presentation;


import com.pbapp.features.vehicles_list.modess.VehiclePresentationModel;

import java.util.List;


public interface VehicleListContract {

    interface View {

        void bindDataToList(List<VehiclePresentationModel> vehicles);
    }

    interface Presenter {

        void onAttached();

        void onDetached();
    }
}
