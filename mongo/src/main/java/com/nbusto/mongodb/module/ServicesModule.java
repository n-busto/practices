package com.nbusto.mongodb.module;

import com.mongodb.client.MongoClient;
import com.nbusto.mongodb.services.MongoPingService;
import com.nbusto.mongodb.services.PingService;
import dagger.Module;
import dagger.Provides;
import org.bson.Document;

@Module
public interface ServicesModule {

    @Provides
    static PingService<Document> getMongoPingModule(MongoClient client) {
        return new MongoPingService(client);
    }
}
