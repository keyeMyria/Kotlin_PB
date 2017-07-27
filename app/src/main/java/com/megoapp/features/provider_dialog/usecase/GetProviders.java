package com.megoapp.features.provider_dialog.usecase;


import com.megoapp.features.provider_dialog.models.ProviderPresentationModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

import static com.megoapp.features.filter_dialog.models.FilterPresentationModel.ContentType.ITEM_CONTENT;
import static com.megoapp.features.filter_dialog.models.FilterPresentationModel.ContentType.SECTION_HEADER;
import static io.reactivex.Single.defer;
import static io.reactivex.Single.just;

public interface GetProviders {
    Single<List<ProviderPresentationModel>> call();
}

final class GetProvidersImpl implements GetProviders {

    @Inject
    public GetProvidersImpl() {
    }

    @Override
    public Single<List<ProviderPresentationModel>> call() {
        List<ProviderPresentationModel> filters = new ArrayList<>();

        filters.add(new ProviderPresentationModel("DriveNow", false));
        filters.add(new ProviderPresentationModel("Car2Go", false));
        filters.add(new ProviderPresentationModel("MultiCity", false));
        filters.add(new ProviderPresentationModel("Emmy", false));
        filters.add(new ProviderPresentationModel("Coup", false));
        filters.add(new ProviderPresentationModel("Emov", false));

        return defer(() -> just(filters));
    }
}
