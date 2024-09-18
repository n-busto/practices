package com.nbusto.mongodb.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Properties(Mongo mongo) {

  public static record Mongo(
    @JsonProperty("connection-string")
    String connectionString,
    @JsonProperty("password")
    String password
  ) {

    public String calculateConnectionString() {
      return connectionString.replace("<db_password>", password);
    }
  }
}
