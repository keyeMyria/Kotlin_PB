package com.pbapp.utilities.rx;


import io.reactivex.disposables.Disposable;

public interface RxDisposables {

    void add(Disposable disposable);

    void clear();
}
