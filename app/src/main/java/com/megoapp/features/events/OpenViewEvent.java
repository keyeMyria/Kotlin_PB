package com.megoapp.features.events;

/**
 * The view open event
 */

public class OpenViewEvent {


    public final ViewTag viewTag;

    public OpenViewEvent(ViewTag viewTag) {
        this.viewTag = viewTag;
    }


    public enum ViewTag {
        VEHICLE_LIST,
    }
}
