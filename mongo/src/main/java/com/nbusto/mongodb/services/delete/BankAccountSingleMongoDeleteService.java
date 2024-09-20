package com.nbusto.mongodb.services.delete;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public record BankAccountSingleMongoDeleteService(MongoCollection<Document> collection)
  implements MongoDeleteService {

  public BankAccountSingleMongoDeleteService(MongoClient client) {
    this(client.getDatabase("bank").getCollection("accounts"));
  }

  @Override
  public DeleteResult delete(Bson query) {
    return collection.deleteOne(query);
  }
}
