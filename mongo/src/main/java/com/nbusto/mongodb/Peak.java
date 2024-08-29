package com.nbusto.mongodb;

import com.mongodb.MongoException;
import com.nbusto.mongodb.module.MongoModule;
import com.nbusto.mongodb.module.PropertiesModule;
import com.nbusto.mongodb.module.ServicesModule;
import com.nbusto.mongodb.services.PingService;
import dagger.Component;
import org.bson.Document;

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

    @Component(modules = {ServicesModule.class, MongoModule.class, PropertiesModule.class})
    protected interface MongoSettings {
        PingService<Document> pingService();
    }
}
