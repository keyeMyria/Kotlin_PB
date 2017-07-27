package com.megoapp.data;


import com.apollographql.apollo.ApolloClient;
import com.megoapp.data.storage.Storage;

public interface DataComponent {

    Storage exposeStorage();

    ApolloClient exposeApolloClient();
}
