package com.nbusto.mongodb.services.update;

import com.mongodb.client.result.UpdateResult;
import org.bson.conversions.Bson;

public interface MongoUpdateService {
    UpdateResult update(Bson query, Bson updates);
}
