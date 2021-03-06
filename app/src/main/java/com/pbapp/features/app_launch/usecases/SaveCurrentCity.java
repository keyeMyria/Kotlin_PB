package com.pbapp.features.app_launch.usecases;


import com.pbapp.Consts;
import com.pbapp.data.storage.Storage;

import javax.inject.Inject;

import io.reactivex.Single;

public interface SaveCurrentCity {

    Single<String> call(String city);
}


final class SaveCurrentCityImpl implements SaveCurrentCity {

    private final Storage storage;

    @Inject
    public SaveCurrentCityImpl(Storage storage) {
        this.storage = storage;
    }


    @Override
    public Single<String> call(String city) {
        storage.setValue(Consts.KEY_CURRENT_CITY, city);
        return Single.just(city);
    }
}