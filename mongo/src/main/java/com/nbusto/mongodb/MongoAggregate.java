package com.nbusto.mongodb;

import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BsonField;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MongoAggregate {

  private final List<Bson> aggregations;

  private MongoAggregate(List<Bson> aggregations) {
    this.aggregations = Collections.unmodifiableList(aggregations);
  }

  public List<Bson> getAggregates() {
    return aggregations;
  }

  public enum FilterType {
    EQUALS,
    GREATER_THAN,
    GREATER_OR_EQUALS_THAN,
    LOWER_THAN,
    LOWER_OR_EQUALS_THAN;
  }

  public static class Builder {
    private final List<Bson> aggregations = new ArrayList<>();

    public MongoAggregate build() {
      return new MongoAggregate(aggregations);
    }

    public Builder comparativeFilter(FilterType filterType, String fieldName, Object value) {
      final var filter = switch (filterType) {
        case EQUALS -> Filters.eq(fieldName, value);
        case GREATER_THAN -> Filters.gt(fieldName, value);
        case GREATER_OR_EQUALS_THAN -> Filters.gte(fieldName, value);
        case LOWER_THAN -> Filters.lt(fieldName, value);
        case LOWER_OR_EQUALS_THAN -> Filters.lte(fieldName, value);
      };
      aggregations.add(filter);
      return this;
    }

    public Builder existsFilter(String fieldName) {
      aggregations.add(Filters.exists(fieldName));
      return this;
    }

    public Builder group(String groupId, BsonField... fieldAccumulators) {
      aggregations.add(Aggregates.group(groupId, fieldAccumulators));
      return this;
    }
  }
}
