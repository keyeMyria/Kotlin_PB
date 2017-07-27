package com.megoapp.features.filter_dialog.presentation;


import com.megoapp.features.filter_dialog.models.FilterPresentationModel;

import java.util.List;

public interface FilterDialogContract {

    interface View {

        void loadFilters(List<FilterPresentationModel> filters);
    }

    interface Presenter {

        void onAttached();

        void onDetached();
    }
}
