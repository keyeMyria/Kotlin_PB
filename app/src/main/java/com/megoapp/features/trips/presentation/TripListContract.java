package com.megoapp.features.trips.presentation;


public interface TripListContract {

    interface View {

    }

    interface Presenter {

        void onAttached();

        void onDetached();
    }
}
