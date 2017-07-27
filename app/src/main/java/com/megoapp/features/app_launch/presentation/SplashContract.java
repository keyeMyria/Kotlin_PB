package com.megoapp.features.app_launch.presentation;


public interface SplashContract {
    interface View {

        void goToMainView(String city);

        void goToError();

        void showNoService();
    }

    interface Presenter {
        void onCreate();

        void onDestroy();
    }
}
