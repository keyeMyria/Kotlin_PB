package com.megoapp.features.providers.usecases;


import com.megoapp.features.providers.models.ProvidersPresentationModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

import static com.megoapp.features.providers.models.ProvidersPresentationModel.ContentType.CAR_ITEM;
import static com.megoapp.features.providers.models.ProvidersPresentationModel.ContentType.HEADER;
import static com.megoapp.features.providers.models.ProvidersPresentationModel.ContentType.SCOOTER_ITEM;
import static io.reactivex.Single.defer;
import static io.reactivex.Single.just;

public interface GetAllAvailableProviders {

    Single<List<ProvidersPresentationModel>> call();
}

final class GetAllAvailableProvidersImpl implements GetAllAvailableProviders {

    @Inject
    public GetAllAvailableProvidersImpl() {
    }


    @Override
    public Single<List<ProvidersPresentationModel>> call() {

        List<ProvidersPresentationModel> providers = new ArrayList<>();
        providers.add(new ProvidersPresentationModel("Car", HEADER, -1));
        providers.add(new ProvidersPresentationModel("DriveNow", CAR_ITEM, -1));
        providers.add(new ProvidersPresentationModel("Car2Go", CAR_ITEM, -1));
        providers.add(new ProvidersPresentationModel("MultiCity", CAR_ITEM, -1));
        providers.add(new ProvidersPresentationModel("Scooter", HEADER, -1));
        providers.add(new ProvidersPresentationModel("Emmy", SCOOTER_ITEM, -1));
        providers.add(new ProvidersPresentationModel("Coup", SCOOTER_ITEM, -1));
        providers.add(new ProvidersPresentationModel("Emov", SCOOTER_ITEM, -1));

        return defer(() -> just(providers));
    }
}
