package com.nbusto.mongodb.services.retrieve;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public record BankAccountMongoRetrieveService(MongoCollection<Document> collection) implements MongoRetrieveService {

    public BankAccountMongoRetrieveService(MongoClient client) {
        this(client.getDatabase("bank").getCollection("accounts"));
    }

    @Override
    public List<Document> retrieve(Bson query) {
        final var list = new ArrayList<Document>();
        collection.find(query)
                .forEach(list::add);

        return list;
    }
}
