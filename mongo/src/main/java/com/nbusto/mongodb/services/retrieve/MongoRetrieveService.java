package com.nbusto.mongodb.services.retrieve;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public interface MongoRetrieveService {
  List<Document> retrieve(Bson query);
}
