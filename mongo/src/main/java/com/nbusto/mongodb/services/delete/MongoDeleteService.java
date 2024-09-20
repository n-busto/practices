package com.nbusto.mongodb.services.delete;

import com.mongodb.client.result.DeleteResult;
import org.bson.conversions.Bson;

public interface MongoDeleteService {
  DeleteResult delete(Bson query);
}
