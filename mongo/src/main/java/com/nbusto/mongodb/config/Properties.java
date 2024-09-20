package com.nbusto.mongodb.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URLEncoder;
import java.nio.charset.Charset;

public record Properties(
  @JsonProperty("default-charset") Charset defaultCharset,
  Mongo mongo) {

  public record Mongo(
    @JsonProperty("connection-string")
    String connectionString,
    @JsonProperty("username")
    String username,
    @JsonProperty("password")
    String password
  ) {
    public String calculateConnectionString(Charset charset) {
        return
          connectionString.replace("<db_password>", encode(password, charset))
            .replace("<username>", encode(username, charset));
    }

    private String encode(String value, Charset charset) {
      return URLEncoder.encode(value, charset);
    }
  }
}
