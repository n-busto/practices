package com.nbusto.mongodb.module;

import com.nbusto.mongodb.config.EnvResolverYaml;
import dagger.Module;
import dagger.Provides;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.env.EnvScalarConstructor;

import java.util.Map;

@Module
public interface PropertiesModule {

    @Provides
    static Map<String, Object> getProperties() {
        final var inputStream = PropertiesModule.class.getClassLoader()
                .getResourceAsStream("properties.yaml");

        return new EnvResolverYaml().load(inputStream);
    }
}
