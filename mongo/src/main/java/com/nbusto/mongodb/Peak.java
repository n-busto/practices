package com.nbusto.mongodb;

import com.mongodb.MongoException;
import com.nbusto.mongodb.module.MapperModule;
import com.nbusto.mongodb.module.MongoModule;
import com.nbusto.mongodb.module.PropertiesModule;
import com.nbusto.mongodb.module.ServicesModule;
import com.nbusto.mongodb.services.ping.PingService;
import dagger.Component;
import org.bson.Document;

import javax.inject.Singleton;

public class Peak {
    public static void main(String[] args) {
        try {
            final var result = DaggerPeak_MongoSettings.builder().build().pingService().ping();
            System.out.println("Pinged your deployment. You successfully connected!");
            System.out.println(result);
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
    }
}
