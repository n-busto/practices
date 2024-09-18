package com.nbusto.mongodb.services.find;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

public record BankAccountMongoFindService(MongoCollection<Document> collection)
  implements MongoFindService {

  public BankAccountMongoFindService(MongoClient client) {
    this(client.getDatabase("bank").getCollection("accounts"));
  }

  @Override
  public Document find(Bson query) {
    return collection.find(query).first();
  }
}
