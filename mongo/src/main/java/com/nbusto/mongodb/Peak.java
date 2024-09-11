package com.nbusto.mongodb;

import com.mongodb.MongoException;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.nbusto.mongodb.module.MapperModule;
import com.nbusto.mongodb.module.MongoModule;
import com.nbusto.mongodb.module.PropertiesModule;
import com.nbusto.mongodb.module.ServicesModule;
import com.nbusto.mongodb.services.find.MongoFindService;
import com.nbusto.mongodb.services.ping.PingService;
import com.nbusto.mongodb.services.retrieve.MongoRetrieveService;
import dagger.Component;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.inject.Singleton;

public class Peak {
    private final static Bson QUERY = Filters.eq("account_id", "1");

    public static void main(String[] args) {
        try {
            final var result = DaggerPeak_MongoSettings.builder().build().pingService().ping();
            System.out.println("Pinged your deployment. You successfully connected!");
            System.out.println(result);

            System.out.println(DaggerPeak_MongoSettings.builder().build().mongoFindService().find(QUERY));
            System.out.println(DaggerPeak_MongoSettings.builder().build().mongoRetrieveService().retrieve(QUERY));
        } catch (MongoException e) {
            e.printStackTrace();
        }
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
    }
}
