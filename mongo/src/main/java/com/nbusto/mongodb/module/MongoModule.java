package com.nbusto.mongodb.module;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.nbusto.mongodb.config.Properties;
import dagger.Module;
import dagger.Provides;

@Module
public interface MongoModule {
    @Provides
    static ServerApi getMongoServer() {
        return ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
    }

    @Provides
    static MongoClientSettings getMongoSettings(ServerApi server, Properties properties) {
        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(properties.mongo().calculateConnectionString()))
                .serverApi(server)
                .build();
    }

    @Provides
    static MongoClient getMongoClient(MongoClientSettings settings) {
        return MongoClients.create(settings);
    }
}
