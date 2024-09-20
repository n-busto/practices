package com.nbusto.mongodb.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.TransactionBody;

public record MongoTransactionService(MongoClient client) {

  public <T> T execute(TransactionBody<T> body) {
    final var clientSession = client.startSession();
    final var result = clientSession.withTransaction(body);
    clientSession.close();

    return result;
  }
}
