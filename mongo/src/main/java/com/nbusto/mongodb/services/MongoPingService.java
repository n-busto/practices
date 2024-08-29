package com.nbusto.mongodb.services;

import com.mongodb.client.MongoClient;
import org.bson.Document;

import javax.inject.Inject;

public class MongoPingService implements PingService<Document> {
    private final MongoClient client;

    @Inject
    public MongoPingService(MongoClient client) {
        this.client = client;
    }


    @Override
    public Document ping() {
        return client
                .getDatabase("admin")
                .runCommand(new org.bson.Document("ping", 1));
    }
}
