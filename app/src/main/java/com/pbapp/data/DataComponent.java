package com.pbapp.data;


import com.apollographql.apollo.ApolloClient;
import com.pbapp.data.storage.Storage;

public interface DataComponent {

    Storage exposeStorage();

    ApolloClient exposeApolloClient();
}
