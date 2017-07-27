package com.megoapp.features.app_launch.usecases;

import com.apollographql.android.rx2.Rx2Apollo;
import com.apollographql.apollo.ApolloClient;
import com.megoapp.graphql.FeedQuery;
import com.megoapp.graphql.type.FeedType;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * A dummy use case to fetch feed entries from apollo example
 */
public interface FetchFeedEntries {

    Single<FeedQuery.Data> call();
}

final class FetchFeedEntriesImpl implements FetchFeedEntries {

    private final ApolloClient apolloClient;

    @Inject
    public FetchFeedEntriesImpl(ApolloClient apolloClient) {
        this.apolloClient = apolloClient;
    }

    @Override
    public Single<FeedQuery.Data> call() {

        return Rx2Apollo.from(apolloClient.newCall(FeedQuery.builder()
                .limit(10)
                .type(FeedType.HOT)
                .build()));
    }
}
