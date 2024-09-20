package com.nbusto.mongodb;

import com.mongodb.MongoException;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.nbusto.mongodb.module.MapperModule;
import com.nbusto.mongodb.module.MongoModule;
import com.nbusto.mongodb.module.PropertiesModule;
import com.nbusto.mongodb.module.ServicesModule;
import com.nbusto.mongodb.services.delete.MongoDeleteService;
import com.nbusto.mongodb.services.find.MongoFindService;
import com.nbusto.mongodb.services.ping.PingService;
import com.nbusto.mongodb.services.retrieve.MongoRetrieveService;
import com.nbusto.mongodb.services.update.MongoUpdateService;
import dagger.Component;
import org.bson.Document;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.logging.Filter;

public class Peak {

  public static void main(String[] args) {
    try {
      final var result = DaggerPeak_MongoSettings.builder().build().pingService().ping();
      System.out.println("Pinged your deployment. You successfully connected!");
      System.out.println(result);

      // Read
      sout(buildSettings().mongoFindService().find(Filters.empty()));
      sout(buildSettings().mongoRetrieveService().retrieve(Filters.empty()));

      // Update
      sout(buildSettings().mongoBulkUpdateService()
        .update(
          Filters.eq("account_id", "1"),
          Updates.set("account_status", "inactive")));
      sout(buildSettings().mongoSingleUpdateService()
        .update(
          Filters.eq("account_id", "1"),
          Updates.combine(
            Updates.set("account_status", "active"),
            Updates.inc("balance", 100))));

      // Delete
      sout(buildSettings().mongoBulkDeleteService().delete(Filters.eq("account_id", "-1")));
      sout(buildSettings().mongoSingleDeleteService().delete(Filters.eq("account_id", "-1")));
    } catch (MongoException e) {
      e.printStackTrace();
    }
  }

  private static Peak.MongoSettings buildSettings() {
    return DaggerPeak_MongoSettings.builder().build();
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
  }
}
