package com.nbusto.mongodb;

import com.mongodb.MongoException;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.nbusto.mongodb.module.MapperModule;
import com.nbusto.mongodb.module.MongoModule;
import com.nbusto.mongodb.module.PropertiesModule;
import com.nbusto.mongodb.module.ServicesModule;
import com.nbusto.mongodb.services.MongoTransactionService;
import com.nbusto.mongodb.services.create.MongoCreateService;
import com.nbusto.mongodb.services.delete.MongoDeleteService;
import com.nbusto.mongodb.services.find.MongoFindService;
import com.nbusto.mongodb.services.ping.PingService;
import com.nbusto.mongodb.services.retrieve.MongoRetrieveService;
import com.nbusto.mongodb.services.update.MongoUpdateService;
import dagger.Component;
import org.bson.Document;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.UUID;

public class Peak {

  public static void main(String[] args) {
    try {
      final var resources = DaggerPeak_MongoSettings.builder().build();
      final var result = DaggerPeak_MongoSettings.builder().build().pingService().ping();
      System.out.println("Pinged your deployment. You successfully connected!");
      System.out.println(result);

      // Create
      final var documentId = UUID.randomUUID().toString();
      sout(resources.mongoCreateService().insert(new Document("test", documentId)
        .append("text", "first")));

      // Read
      sout(resources.mongoFindService().find(Filters.eq("test", documentId)));
      sout(resources.mongoRetrieveService().retrieve(Filters.eq("test", documentId)));

      // Update
      sout(resources.mongoBulkUpdateService()
        .update(
          Filters.eq("test", documentId),
          Updates.set("text", "inactive")));
      sout(resources.mongoSingleUpdateService()
        .update(
          Filters.eq("test", documentId),
          Updates.combine(
            Updates.set("text", "active"),
            Updates.pull("balance", 100))));

      // Delete
      sout(resources.mongoBulkDeleteService().delete(Filters.eq("test", "-1")));
      sout(resources.mongoSingleDeleteService().delete(Filters.eq("test", "-1")));

      // Transaction
      sout(resources.mongoTransactionService()
        .execute(() -> {
          resources.mongoBulkUpdateService()
            .update(
              Filters.eq("account_id", "1"),
              Updates.set("account_status", "inactive"));
          resources.mongoSingleUpdateService()
            .update(
              Filters.eq("account_id", "1"),
              Updates.combine(
                Updates.set("account_status", "active"),
                Updates.inc("balance", 100)));

          return "Updates done";
        }));
    } catch (MongoException e) {
      e.printStackTrace();
    }
  }

  private static void sout(Object o) {
    System.out.println(o);
  }

  @Singleton
  @Component(modules = {
    ServicesModule.class,
    MongoModule.class,
    PropertiesModule.class,
    MapperModule.class})
  protected interface MongoSettings {
    PingService<Document> pingService();

    MongoCreateService mongoCreateService();

    MongoFindService mongoFindService();

    MongoRetrieveService mongoRetrieveService();

    @Named("mongoBulkUpdate")
    MongoUpdateService mongoBulkUpdateService();

    @Named("mongoSingleUpdate")
    MongoUpdateService mongoSingleUpdateService();

    @Named("mongoBulkDelete")
    MongoDeleteService mongoBulkDeleteService();

    @Named("mongoSingleDelete")
    MongoDeleteService mongoSingleDeleteService();

    MongoTransactionService mongoTransactionService();
  }
}
