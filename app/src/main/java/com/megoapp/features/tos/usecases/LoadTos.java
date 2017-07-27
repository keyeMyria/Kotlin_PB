package com.megoapp.features.tos.usecases;

import javax.inject.Inject;


public interface LoadTos {
    String call();
}

final class LoadTosImpl implements LoadTos {

    @Inject
    public LoadTosImpl() {
    }

    @Override
    public String call() {
        return "The real tos retrieved from BE";
    }
}
