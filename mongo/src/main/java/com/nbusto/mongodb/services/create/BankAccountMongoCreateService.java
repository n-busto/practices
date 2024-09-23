package com.nbusto.mongodb.services.create;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public record BankAccountMongoCreateService
  (MongoCollection<Document> collection) implements MongoCreateService {

  public BankAccountMongoCreateService(MongoClient client) {
    this(client.getDatabase("bank").getCollection("accounts"));
  }

  @Override
  public InsertOneResult insert(Document document) {
    return collection.insertOne(document);
  }
}
