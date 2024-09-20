package com.nbusto.mongodb.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public record Properties(Mongo mongo) {

  public static record Mongo(
    @JsonProperty("connection-string")
    String connectionString,
    @JsonProperty("username")
    String username,
    @JsonProperty("password")
    String password
  ) {
    private final static Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public String calculateConnectionString() {
        return
          connectionString.replace("<db_password>", encode(password))
            .replace("<username>", encode(username));
    }

    private String encode(String value) {
      return URLEncoder.encode(value, DEFAULT_CHARSET);
    }
  }
}
