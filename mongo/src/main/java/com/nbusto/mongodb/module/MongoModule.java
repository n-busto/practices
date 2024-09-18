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
  static MongoClient getMongoClient(ConnectionString connectionString) {
    return MongoClients.create(getMongoSettings(connectionString));
  }

  @Singleton
  @Provides
  static ConnectionString getConnectionString(Properties properties) {
    return new ConnectionString(properties.mongo().calculateConnectionString());
  }

  static MongoClientSettings getMongoSettings(ConnectionString connectionString) {
    return MongoClientSettings.builder()
      .applyConnectionString(connectionString)
      .serverApi(getMongoServer())
      .build();
  }

  static ServerApi getMongoServer() {
    return ServerApi.builder()
      .version(ServerApiVersion.V1)
      .build();
  }
}
