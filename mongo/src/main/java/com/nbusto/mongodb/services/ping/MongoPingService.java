package com.nbusto.mongodb.services.ping;

import com.mongodb.client.MongoClient;
import org.bson.Document;

import javax.inject.Inject;

public record MongoPingService(MongoClient client)
  implements PingService<Document> {

  @Inject
  public MongoPingService {}

  @Override
  public Document ping() {
    return client
      .getDatabase("admin")
      .runCommand(new Document("ping", 1));
  }
}
