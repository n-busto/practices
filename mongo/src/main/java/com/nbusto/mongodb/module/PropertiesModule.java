package com.nbusto.mongodb.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.nbusto.mongodb.config.Properties;
import dagger.Module;
import dagger.Provides;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.env.EnvScalarConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Module
public interface PropertiesModule {
    // TODO property object method does not replace env vars

    @Provides
    static Map<String, Object> getProperties() {
        return getYaml().load(getInputStream());
    }

    static Yaml getYaml() {
        final var yaml = new Yaml(new EnvScalarConstructor());
        yaml.addImplicitResolver(EnvScalarConstructor.ENV_TAG, EnvScalarConstructor.ENV_FORMAT, "$");
        return yaml;
    }

    @Provides
    static Properties getPropertiesClass() {
        final var mapper = new ObjectMapper(new YAMLFactory());

        try {
            return mapper.readValue(getInputStream(), Properties.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    static InputStream getInputStream() {
        return PropertiesModule.class.getClassLoader()
                .getResourceAsStream("properties.yaml");
    }
}
