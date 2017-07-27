package com.pbapp.views.activities;


import android.view.MenuItem;

public interface AppActivityContract {

    interface View {

        void addMapView();

        void openDrawer();

        void closeDrawer();

        void lockDrawer();

        void unlockDrawer();

        void goToVehicleList();

        void goToTrips();

        void goToProviders();

        void goToQuestions();

        void goToAbout();

        void goToLegal();

        void goBack();

        void changeMenuIconToCross();

        void quitApp();

        void invokeSystemBack();

        void showAppToolbar();

        void hideAppToolbar();
    }

    interface Presenter {

        void onStart();

        void onStop();

        void onDestroy();

        void onToolbarMenuTapped();

        boolean onDrawerItemTapped(MenuItem drawerItem);

        void onBackTapped();

        void onDrawerOpened();

        void onDrawerClosed();
    }
}
