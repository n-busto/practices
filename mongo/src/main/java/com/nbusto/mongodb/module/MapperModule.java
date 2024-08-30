package com.nbusto.mongodb.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;

@Module
public interface MapperModule {

    @Provides
    static ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
