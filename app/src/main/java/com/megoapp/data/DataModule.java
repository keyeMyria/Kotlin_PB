package com.megoapp.data;


import android.content.Context;
import android.content.SharedPreferences;

import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.cache.http.DiskLruCacheStore;
import com.apollographql.apollo.cache.http.ResponseCacheStore;
import com.apollographql.apollo.cache.http.TimeoutEvictionStrategy;
import com.megoapp.Consts;
import com.megoapp.data.storage.Storage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class DataModule {

    private static final int DEFAULT_CACHE_SIZE = 1024 * 1024;
    private static final long DEFAULT_CACHE_STALE_THRESHOLD = 5;

    @Provides
    @Singleton
    SharedPreferences providesSharePreference(Context appContext) {
        return appContext.getSharedPreferences(Consts.SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Storage provideStorage(SharedPreferences sharedPreferences) {
        return new Storage(sharedPreferences);
    }


    @Provides
    @Singleton
    ApolloClient provideApolloClient() {
        return ApolloClient.builder()
                .serverUrl(Consts.BASE_URL)
                .httpCache(createResponseCacheStore(), new TimeoutEvictionStrategy(DEFAULT_CACHE_STALE_THRESHOLD, TimeUnit.SECONDS))
                .okHttpClient(createOkHttpClient())
                .build();
    }

    private ResponseCacheStore createResponseCacheStore() {
        return new DiskLruCacheStore(new File("/cache/"), DEFAULT_CACHE_SIZE);
    }

    private static OkHttpClient createOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
        return client;
    }
}
