package com.megoapp.utilities.rx.impl;


import com.megoapp.utilities.rx.ThreadTransformer;
import com.megoapp.utilities.rx.qualifiers.IOThreadPref;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;


public final class WorkThreadTransformer implements ThreadTransformer {

    private final Scheduler subscribeOnScheduler;
    private final Scheduler observeOnScheduler;

    @Inject
    public WorkThreadTransformer(@IOThreadPref Scheduler subscribeOnScheduler,
                                 @IOThreadPref Scheduler observeOnScheduler) {
        this.subscribeOnScheduler = subscribeOnScheduler;
        this.observeOnScheduler = observeOnScheduler;
    }

    @Override
    public <T> SingleTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler);
    }
}
