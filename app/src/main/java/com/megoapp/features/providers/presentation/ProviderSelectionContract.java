package com.megoapp.features.providers.presentation;


import com.megoapp.features.providers.models.ProvidersPresentationModel;

import java.util.List;

public interface ProviderSelectionContract {

    interface View {

        void loadProviderData(List<ProvidersPresentationModel> providers);
    }

    interface Presenter {

        void onAttached();

        void onDetached();
    }
}
