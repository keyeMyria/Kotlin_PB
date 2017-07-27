package com.megoapp.features.app_launch.presentation;

import android.util.Log;

import com.megoapp.features.app_launch.usecases.FetchFeedEntries;
import com.megoapp.features.app_launch.usecases.GetCurrentLocation;
import com.megoapp.features.app_launch.usecases.SaveCurrentCity;
import com.megoapp.graphql.FeedQuery;
import com.megoapp.utilities.StringUtils;
import com.megoapp.utilities.rx.RxDisposableFactory;
import com.megoapp.utilities.rx.RxDisposables;
import com.megoapp.utilities.rx.ThreadTransformer;

import javax.inject.Inject;

public final class SplashPresenter implements SplashContract.Presenter {

    private final SplashContract.View view;
    private final GetCurrentLocation getCurrentLocation;
    private final SaveCurrentCity saveCurrentCity;
    private final FetchFeedEntries fetchFeedEntries;
    private final StringUtils stringUtils;
    private final ThreadTransformer threadTransformer;
    private final RxDisposableFactory rxDisposableFactory;
    private final RxDisposables disposables;

    @Inject
    public SplashPresenter(SplashContract.View view,
                           GetCurrentLocation getCurrentLocation,
                           SaveCurrentCity saveCurrentCity,
                           FetchFeedEntries fetchFeedEntries,
                           StringUtils stringUtils,
                           ThreadTransformer threadTransformer,
                           RxDisposableFactory rxDisposableFactory) {
        this.view = view;
        this.getCurrentLocation = getCurrentLocation;
        this.saveCurrentCity = saveCurrentCity;
        this.fetchFeedEntries = fetchFeedEntries;
        this.stringUtils = stringUtils;
        this.threadTransformer = threadTransformer;
        this.disposables = rxDisposableFactory.get();
        this.rxDisposableFactory = rxDisposableFactory;
    }

    @Override
    public void onCreate() {
        fetchCurrentLocation();

        fetchFeedEntriesFromGitHunt();
    }

    @Override
    public void onDestroy() {
        disposables.clear();
    }

    private void fetchFeedEntriesFromGitHunt() {
        disposables.add(fetchFeedEntries.call().compose(threadTransformer.applySchedulers())
                .subscribe(
                        response -> {
                            for (FeedQuery.Data.FeedEntry feedEntry : response.feedEntries()) {
                                Log.d("Apollo-Exp", "feedEntry" + feedEntry);
                            }
                        },
                        err -> {
                            Log.d("Apollo-Exp", "error happens" + err.getMessage());
                        }
                ));
    }

    private void fetchCurrentLocation() {
        disposables.add(getCurrentLocation.call()
                .flatMap(city -> saveCurrentCity.call(city))
                .compose(threadTransformer.applySchedulers())
                .subscribe(
                        savedCity -> {
                            if (stringUtils.isBlank(savedCity)) {
                                view.showNoService();
                            } else {
                                view.goToMainView(savedCity);
                            }
                        },
                        e -> view.goToError()));
    }


}
