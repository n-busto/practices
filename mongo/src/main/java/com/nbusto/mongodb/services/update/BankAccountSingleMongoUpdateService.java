package com.nbusto.mongodb.services.update;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public record BankAccountSingleMongoUpdateService(MongoCollection<Document> collection) implements MongoUpdateService {

    public BankAccountSingleMongoUpdateService(MongoClient client) {
        this(client.getDatabase("bank").getCollection("accounts"));
    }

    @Override
    public UpdateResult update(Bson query, Bson updates) {
        return collection.updateOne(query, updates);
    }
}
