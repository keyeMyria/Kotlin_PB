package com.megoapp.features.vehicles_list.usecases;


import com.megoapp.features.vehicles_list.modess.VehiclePresentationModel;
import com.megoapp.features.vehicles_list.modess.VehicleType;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

import static io.reactivex.Single.defer;
import static io.reactivex.Single.just;

public interface GetAvailableVehiclesByGeoHash {

    Single<List<VehiclePresentationModel>> call();

}

final class GetAvailableVehiclesByGeoHashImpl implements GetAvailableVehiclesByGeoHash {

    @Inject
    public GetAvailableVehiclesByGeoHashImpl() {
    }

    @Override
    public Single<List<VehiclePresentationModel>> call() {
        List<VehiclePresentationModel> vehicles = new ArrayList<>();
        vehicles.add(new VehiclePresentationModel
                ("0", "B-GO2346", "Charlottesstr. 7", "13m", "78%", VehicleType.GAS));
        vehicles.add(new VehiclePresentationModel
                ("1", "B-GO4245", "Rosenthalerstr. 1", "15m", "66%", VehicleType.GAS));
        vehicles.add(new VehiclePresentationModel
                ("2", "B-GO4235", "Grillparzstr. 1", "23m", "62%", VehicleType.ELECTRICITY));
        vehicles.add(new VehiclePresentationModel
                ("3", "B-GO4255", "Berlinerstr 3", "27m", "58%", VehicleType.GAS));
        vehicles.add(new VehiclePresentationModel
                ("4", "B-GO4265", "Karl marx alle 5", "30m", "55%", VehicleType.GAS));
        vehicles.add(new VehiclePresentationModel
                ("5", "B-GO4275", "Mohrenstr 60", "35m", "34%", VehicleType.GAS));
        vehicles.add(new VehiclePresentationModel
                ("6", "B-GO4285", "Katz-bach Str 4", "39", "29%", VehicleType.ELECTRICITY));
        vehicles.add(new VehiclePresentationModel
                ("7", "B-GO4295", "Voltastr 6", "40m", "28%", VehicleType.GAS));
        vehicles.add(new VehiclePresentationModel
                ("8", "B-GO4205", "Fernberlinerstr 10", "40m", "15%", VehicleType.ELECTRICITY));
        vehicles.add(new VehiclePresentationModel
                ("9", "B-GO4345", "Kotti str 345", "40m", "6%", VehicleType.GAS));

        return defer(() -> just(vehicles));
    }
}




