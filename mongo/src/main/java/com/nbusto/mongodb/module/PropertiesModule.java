package com.nbusto.mongodb.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.nbusto.mongodb.config.EnvResolverYaml;
import com.nbusto.mongodb.config.Properties;
import dagger.Module;
import dagger.Provides;

import java.io.IOException;
import java.util.Map;

@Module
public interface PropertiesModule {
    // TODO property object method does not replace env vars

    @Provides
    static Map<String, Object> getProperties() {
        final var inputStream = PropertiesModule.class.getClassLoader()
                .getResourceAsStream("properties.yaml");

        return new EnvResolverYaml().load(inputStream);
    }

    @Provides
    static Properties getPropertiesClass() {
        final var mapper = new ObjectMapper(new YAMLFactory());

        try {
            final var inputStream = PropertiesModule.class.getClassLoader()
                    .getResourceAsStream("properties.yaml");

            return mapper.readValue(inputStream, Properties.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
