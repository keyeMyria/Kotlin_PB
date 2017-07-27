package com.megoapp.utilities;


import com.megoapp.utilities.rx.RxDisposables;
import com.megoapp.utilities.rx.ThreadTransformer;
import com.megoapp.utilities.rx.impl.CompositeDisposablesImpl;
import com.megoapp.utilities.rx.impl.ViewThreadTransformer;
import com.megoapp.utilities.rx.impl.WorkThreadTransformer;
import com.megoapp.utilities.rx.qualifiers.IOThreadPref;
import com.megoapp.utilities.rx.qualifiers.UIThreadPref;
import com.megoapp.utilities.rx.qualifiers.WorkThreadTransformerPref;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class UtilsModule {

    @Provides
    @Singleton
    StringUtils provideStringUtils() {
        return new StringUtils();
    }

    @Provides
    @Singleton
    ThreadTransformer providesViewThreadTransformer(
            ViewThreadTransformer transformer) {
        return transformer;
    }

    @Provides
    @Singleton
    @WorkThreadTransformerPref
    ThreadTransformer providesWorkThreadTransformer(
            WorkThreadTransformer transformer) {
        return transformer;
    }

    @Provides
    @Singleton
    @IOThreadPref
    Scheduler provideIoScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    @UIThreadPref
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }


    @Provides
    @Singleton
    public RxDisposables provideCompositeDisposables(
            CompositeDisposablesImpl disposables) {
        return disposables;
    }

}
