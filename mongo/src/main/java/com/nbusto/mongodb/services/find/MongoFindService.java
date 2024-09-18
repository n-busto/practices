package com.nbusto.mongodb.services.find;

import org.bson.Document;
import org.bson.conversions.Bson;

public interface MongoFindService {
  Document find(Bson query);
}
