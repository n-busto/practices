package com.nbusto.mongodb.services.aggregation;

import com.nbusto.mongodb.MongoAggregate;
import org.bson.Document;

import java.util.List;

public interface MongoAggregationService {

  List<Document> launchAggregates(MongoAggregate aggregate);
}
