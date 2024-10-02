package com.nbusto.mongodb.services.aggregation;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.nbusto.mongodb.MongoAggregate;
import org.bson.Document;

import java.util.List;
import java.util.stream.StreamSupport;

public record BankAccountMongoAggregationService(
  MongoCollection<Document> collection)
  implements MongoAggregationService {

  public BankAccountMongoAggregationService(MongoClient client) {
    this(client.getDatabase("bank").getCollection("accounts"));
  }

  @Override
  public List<Document> launchAggregates(MongoAggregate aggregate) {
    return StreamSupport
      .stream(
        collection.aggregate(aggregate.getAggregates()).spliterator(),
        false)
      .toList();
  }
}
