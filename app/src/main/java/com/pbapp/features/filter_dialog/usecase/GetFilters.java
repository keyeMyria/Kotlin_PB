package com.pbapp.features.filter_dialog.usecase;


import com.pbapp.features.filter_dialog.models.FilterPresentationModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

import static com.pbapp.features.filter_dialog.models.FilterPresentationModel.ContentType.ITEM_CONTENT;
import static com.pbapp.features.filter_dialog.models.FilterPresentationModel.ContentType.SECTION_HEADER;
import static io.reactivex.Single.defer;
import static io.reactivex.Single.just;

public interface GetFilters {
    Single<List<FilterPresentationModel>> call();
}

final class GetFiltersImpl implements GetFilters {

    @Inject
    public GetFiltersImpl() {
    }

    @Override
    public Single<List<FilterPresentationModel>> call() {
        List<FilterPresentationModel> filters = new ArrayList<>();

        filters.add(new FilterPresentationModel("Transmission", false, SECTION_HEADER));
        filters.add(new FilterPresentationModel("Manual", false, ITEM_CONTENT));
        filters.add(new FilterPresentationModel("Automatic", false, ITEM_CONTENT));
        filters.add(new FilterPresentationModel("Energy", false, SECTION_HEADER));
        filters.add(new FilterPresentationModel("Fuel", false, ITEM_CONTENT));
        filters.add(new FilterPresentationModel("Electric", true, ITEM_CONTENT));
        filters.add(new FilterPresentationModel("Other", false, SECTION_HEADER));
        filters.add(new FilterPresentationModel("Baby Seat", true, ITEM_CONTENT));
        filters.add(new FilterPresentationModel("Gas", false, ITEM_CONTENT));

        return defer(() -> just(filters));
    }
}
