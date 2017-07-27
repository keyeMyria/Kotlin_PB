package com.megoapp.data.location;


import android.content.Context;

import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocationModule {

    @Provides
    @Singleton
    RxLocation provideRxLocation(Context context) {
        return new RxLocation(context);
    }

    @Provides
    @Singleton
    LocationRequest provideDefaultLocationRequest() {
        return LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(1000);
    }

}
