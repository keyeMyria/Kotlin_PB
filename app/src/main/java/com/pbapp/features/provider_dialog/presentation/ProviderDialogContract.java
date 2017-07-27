package com.pbapp.features.provider_dialog.presentation;


import com.pbapp.features.provider_dialog.models.ProviderPresentationModel;

import java.util.List;

public interface ProviderDialogContract {

    interface View {

        void loadProviders(List<ProviderPresentationModel> filters);
    }

    interface Presenter {

        void onAttached();

        void onDetached();
    }
}
