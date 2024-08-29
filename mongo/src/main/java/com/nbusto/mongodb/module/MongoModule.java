package com.nbusto.mongodb.module;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dagger.Module;
import dagger.Provides;

import java.util.Map;

@Module
public interface MongoModule {
    @Provides
    static ServerApi getMongoServer() {
        return ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
    }

    @Provides
    static MongoClientSettings getMongoSettings(ServerApi server, Map<String, Object> properties) {
        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(properties.get("app.mongo.connection-string").toString()))
                .serverApi(server)
                .build();
    }

    @Provides
    static MongoClient getMongoClient(MongoClientSettings settings) {
        return MongoClients.create(settings);
    }
}
