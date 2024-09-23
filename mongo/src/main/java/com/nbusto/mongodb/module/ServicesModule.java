package com.nbusto.mongodb.module;

import com.mongodb.client.MongoClient;
import com.nbusto.mongodb.services.MongoTransactionService;
import com.nbusto.mongodb.services.create.BankAccountMongoCreateService;
import com.nbusto.mongodb.services.create.MongoCreateService;
import com.nbusto.mongodb.services.delete.BankAccountBulkMongoDeleteService;
import com.nbusto.mongodb.services.delete.BankAccountSingleMongoDeleteService;
import com.nbusto.mongodb.services.delete.MongoDeleteService;
import com.nbusto.mongodb.services.find.BankAccountMongoFindService;
import com.nbusto.mongodb.services.find.MongoFindService;
import com.nbusto.mongodb.services.ping.MongoPingService;
import com.nbusto.mongodb.services.ping.PingService;
import com.nbusto.mongodb.services.retrieve.BankAccountMongoRetrieveService;
import com.nbusto.mongodb.services.retrieve.MongoRetrieveService;
import com.nbusto.mongodb.services.update.BankAccountBulkMongoUpdateService;
import com.nbusto.mongodb.services.update.BankAccountSingleMongoUpdateService;
import com.nbusto.mongodb.services.update.MongoUpdateService;
import dagger.Module;
import dagger.Provides;
import org.bson.Document;

import javax.inject.Named;

@Module
public interface ServicesModule {

  @Provides
  static PingService<Document> getMongoPingModule(MongoClient client) {
    return new MongoPingService(client);
  }

  @Provides
  static MongoCreateService getMongoCreateService(MongoClient client) {
    return new BankAccountMongoCreateService(client);
  }

  @Provides
  static MongoFindService getMongoFindService(MongoClient client) {
    return new BankAccountMongoFindService(client);
  }

  @Provides
  static MongoRetrieveService getMongoRetrieveService(MongoClient client) {
    return new BankAccountMongoRetrieveService(client);
  }

  @Provides
  @Named("mongoBulkUpdate")
  static MongoUpdateService getMongoBulkUpdateService(MongoClient client) {
    return new BankAccountBulkMongoUpdateService(client);
  }

  @Provides
  @Named("mongoSingleUpdate")
  static MongoUpdateService getMongoSingleUpdateService(MongoClient client) {
    return new BankAccountSingleMongoUpdateService(client);
  }

  @Provides
  @Named("mongoBulkDelete")
  static MongoDeleteService getMongoBulkDeleteService(MongoClient client) {
    return new BankAccountBulkMongoDeleteService(client);
  }

  @Provides
  @Named("mongoSingleDelete")
  static MongoDeleteService getMongoSingleDeleteService(MongoClient client) {
    return new BankAccountSingleMongoDeleteService(client);
  }

  @Provides
  static MongoTransactionService getTransactionService(MongoClient client) {
    return new MongoTransactionService(client);
  }
}
