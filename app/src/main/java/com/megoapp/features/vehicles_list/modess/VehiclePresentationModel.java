package com.megoapp.features.vehicles_list.modess;


public class VehiclePresentationModel {

    public final String id;
    public final String cardNumber;
    public final String address;
    public final String distance;
    public final String energy;
    public final VehicleType type;

    public VehiclePresentationModel(String id, String cardNumber, String address, String distance, String energy, VehicleType type) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.address = address;
        this.distance = distance;
        this.energy = energy;
        this.type = type;
    }
}
