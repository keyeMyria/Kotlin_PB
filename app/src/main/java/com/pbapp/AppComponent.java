package com.pbapp;


import android.content.Context;
import android.content.res.Resources;

import com.pbapp.data.DataComponent;
import com.pbapp.data.DataModule;
import com.pbapp.data.storage.Storage;
import com.pbapp.data.location.LocationComponent;
import com.pbapp.data.location.LocationModule;
import com.pbapp.utilities.UtilsComponent;
import com.pbapp.utilities.UtilsModule;

import org.greenrobot.eventbus.EventBus;

import java.util.Locale;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, UtilsModule.class, LocationModule.class, DataModule.class})
public interface AppComponent extends UtilsComponent, LocationComponent, DataComponent {

    void inject(App app);

    // expose dependencies to scope graph
    Context exposeAppContext();

    Storage exposeStorage();

    Resources exposeResources();

    Locale exposeLocale();

    EventBus exposeBus();

}
