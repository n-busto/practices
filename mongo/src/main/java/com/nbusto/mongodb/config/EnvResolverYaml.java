package com.nbusto.mongodb.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.env.EnvScalarConstructor;

public class EnvResolverYaml extends Yaml {
    public EnvResolverYaml() {
        super(new EnvScalarConstructor());
        addImplicitResolver(EnvScalarConstructor.ENV_TAG, EnvScalarConstructor.ENV_FORMAT, "$");
    }
}
