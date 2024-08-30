package com.nbusto.mongodb.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nbusto.mongodb.config.Properties;
import dagger.Module;
import dagger.Provides;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.env.EnvScalarConstructor;

import javax.inject.Singleton;
import java.io.InputStream;
import java.util.Map;

@Module
public interface PropertiesModule {

    @Singleton
    @Provides
    static Properties getPropertiesFromMap(ObjectMapper mapper) {
        try {
            return mapper.convertValue(getProperties(), Properties.class);
        }catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    static Map<String, Object> getProperties() {
        final var yaml = new Yaml(new EnvScalarConstructor());
        yaml.addImplicitResolver(EnvScalarConstructor.ENV_TAG, EnvScalarConstructor.ENV_FORMAT, "$");

        return yaml.load(getInputStream());
    }

    static InputStream getInputStream() {
        return PropertiesModule.class.getClassLoader()
                .getResourceAsStream("properties.yaml");
    }
}
