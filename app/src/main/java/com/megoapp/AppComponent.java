package com.megoapp;


import android.content.Context;
import android.content.res.Resources;

import com.megoapp.data.DataComponent;
import com.megoapp.data.DataModule;
import com.megoapp.data.storage.Storage;
import com.megoapp.data.location.LocationComponent;
import com.megoapp.data.location.LocationModule;
import com.megoapp.utilities.UtilsComponent;
import com.megoapp.utilities.UtilsModule;

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
