package com.pbapp.utilities.rx;


import com.pbapp.utilities.rx.impl.CompositeDisposablesImpl;

import javax.inject.Inject;

public class RxDisposableFactory {

    @Inject
    public RxDisposableFactory() {
    }

    public RxDisposables get() {
        return new CompositeDisposablesImpl();
    }
}
