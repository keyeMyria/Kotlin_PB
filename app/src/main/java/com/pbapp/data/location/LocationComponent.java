package com.pbapp.data.location;


import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

public interface LocationComponent {

    RxLocation exposeRxLocation();

    LocationRequest exposeLocationRequest();

}
