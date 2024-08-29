package com.nbusto.mongodb.module;

import dagger.Module;
import dagger.Provides;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

@Module
public interface PropertiesModule {

    @Provides
    static Map<String, Object> getProperties() {
        final var inputStream = PropertiesModule.class.getClassLoader()
                .getResourceAsStream("properties.yaml");

        return new Yaml().load(inputStream);
    }
}
