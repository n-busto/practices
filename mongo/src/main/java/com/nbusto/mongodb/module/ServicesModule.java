package com.nbusto.mongodb.module;

import com.mongodb.client.MongoClient;
import com.nbusto.mongodb.services.find.BankAccountMongoFindService;
import com.nbusto.mongodb.services.find.MongoFindService;
import com.nbusto.mongodb.services.ping.MongoPingService;
import com.nbusto.mongodb.services.ping.PingService;
import dagger.Module;
import dagger.Provides;
import org.bson.Document;

@Module
public interface ServicesModule {

    @Provides
    static PingService<Document> getMongoPingModule(MongoClient client) {
        return new MongoPingService(client);
    }

    @Provides
    static MongoFindService getMongoFindService(MongoClient client) {
        return new BankAccountMongoFindService(client);
    }
}
