package com.nbusto.mongodb.module;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dagger.Module;
import dagger.Provides;

@Module
public interface MongoModule {
    String CONNECTION_STRING = "mongodb+srv://myAtlasDBUser:<db_password>@myatlasclusteredu.nxmfwz3.mongodb.net/?retryWrites=true&w=majority&appName=myAtlasClusterEDU";

    @Provides
    static ServerApi getMongoServer() {
        return ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
    }

    @Provides
    static MongoClientSettings getMongoSettings(ServerApi server) {
        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                .serverApi(server)
                .build();
    }

    @Provides
    static MongoClient getMongoClient(MongoClientSettings settings) {
        return MongoClients.create(settings);
    }
}
