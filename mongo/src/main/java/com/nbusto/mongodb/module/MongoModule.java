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

import javax.inject.Singleton;

@Module
public interface MongoModule {

    @Singleton
    @Provides
    static MongoClient getMongoClient(Properties properties) {
        return MongoClients.create(getMongoSettings(properties));
    }

    static MongoClientSettings getMongoSettings(Properties properties) {
        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(properties.mongo().calculateConnectionString()))
                .serverApi(getMongoServer())
                .build();
    }

    static ServerApi getMongoServer() {
        return ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
    }
}
