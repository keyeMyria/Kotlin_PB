package com.pbapp.utilities.rx;


import io.reactivex.SingleTransformer;

public interface ThreadTransformer {
  <T> SingleTransformer<T, T> applySchedulers();
}
