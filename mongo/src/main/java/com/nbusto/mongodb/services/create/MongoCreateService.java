package com.nbusto.mongodb.services.create;

import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

public interface MongoCreateService {
  InsertOneResult insert(Document document);
}
