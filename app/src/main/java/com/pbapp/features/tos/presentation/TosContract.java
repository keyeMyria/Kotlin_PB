package com.pbapp.features.tos.presentation;


public interface TosContract {

    interface View {

        void showTos(String tos);

        void showLoading();
    }

    interface Presenter {

        void onAttached();

        void onDetached();
    }
}
