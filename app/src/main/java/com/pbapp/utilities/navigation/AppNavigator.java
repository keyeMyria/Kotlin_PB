package com.pbapp.utilities.navigation;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * App flow navigator
 */
public interface AppNavigator {

    int getViewStackSize();

    ViewTag getTopView();

    ViewTag removeTopView();

    void addDrawer();

    void removeDrawer();

    void addView(@NonNull Fragment fragment, @NonNull ViewTag viewTag);

    void goBack();

    enum ViewTag {
        MAP_VIEW("map_view"),
        NAVIGATION_DRAWER("navigation_drawer"),
        PROVIDERS("providers"),
        TRIPS("trips"),
        ABOUT("about"),
        LEGAL("legal"),
        QUESTIONS("questions"),
        VEHICLE_LIST("vehicle_list");

        public final String tag;

        /**
         * @param tag
         */
        ViewTag(final String tag) {
            this.tag = tag;
        }


        @Override
        public String toString() {
            return tag;
        }
    }
}

