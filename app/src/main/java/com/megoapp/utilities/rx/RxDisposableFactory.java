package com.megoapp.utilities.rx;


import com.megoapp.utilities.rx.impl.CompositeDisposablesImpl;

import javax.inject.Inject;

public class RxDisposableFactory {

    @Inject
    public RxDisposableFactory() {
    }

    public RxDisposables get() {
        return new CompositeDisposablesImpl();
    }
}
