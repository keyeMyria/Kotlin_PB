package com.megoapp.features.providers.models;


public class ProvidersPresentationModel {

    public final String label;
    public final ContentType type;
    public final int iconRes;


    public ProvidersPresentationModel(String label, ContentType type, int iconRes) {
        this.label = label;
        this.type = type;
        this.iconRes = iconRes;
    }

    public enum ContentType {
        HEADER,
        SCOOTER_ITEM,
        CAR_ITEM,
    }

}
