package com.megoapp.features.app_launch.usecases;

import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Single;

import static io.reactivex.Single.just;

/**
 * The use case to fetch the user's location (city)
 */
public interface GetCurrentLocation {
    Single<String> call();
}

final class GetCurrentLocationImpl implements GetCurrentLocation {

    private final RxLocation rxLocation;
    private final LocationRequest locationRequest;
    private final Locale locale;

    @Inject
    public GetCurrentLocationImpl(RxLocation rxLocation,
                                  LocationRequest locationRequest,
                                  Locale locale) {

        this.rxLocation = rxLocation;
        this.locationRequest = locationRequest;
        this.locale = locale;
    }

    @Override
    public Single<String> call() {
        return Single.timer(1500, TimeUnit.MILLISECONDS)
                .flatMap(delay -> just(getCity()));
    }

    private String getCity() {
        return "Berlin";
    }


}
