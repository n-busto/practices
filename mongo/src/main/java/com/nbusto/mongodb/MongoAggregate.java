package com.nbusto.mongodb;

import com.mongodb.client.model.*;
import org.bson.Document;
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
    LOWER_OR_EQUALS_THAN
  }



  public static class Builder {
    private final List<Bson> aggregations = new ArrayList<>();
    private List<Bson> projectionPieces = new ArrayList<>();

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

    public Builder sortAscending(String... fields) {
      return orderBy(Sorts.ascending(fields));
    }

    public Builder sortDescending(String... fields) {
      return orderBy(Sorts.descending(fields));
    }

    public Builder orderBy(Bson rule) {
      aggregations.add(Sorts.orderBy(rule));
      return this;
    }

    /**
     * Include the next fields in the projection.
     * <p>
     * WARNING: This projection is introduced in the aggregate only
     * when {@link #consolidateProjection()} method is called
     *
     * @param fields field names to be included
     * @return this same instance
     */
    public Builder include(String... fields) {
      projectionPieces.add(Projections.include(fields));
      return this;
    }

    /**
     * Exclude the next fields in the projection.
     * <p>
     * WARNING: This projection is introduced in the aggregate only
     * when {@link #consolidateProjection()} method is called
     *
     * @param fields field names to be excluded
     * @return same instance
     */
    public Builder excludeId(String... fields) {
      projectionPieces.add(Projections.exclude(fields));
      return this;
    }

    /**
     * Exclude the id field in the projection.
     * <p>
     * WARNING: This projection is introduced in the aggregate only
     * when {@link #consolidateProjection()} method is called
     *
     * @return same instance
     */
    public Builder excludeId() {
      projectionPieces.add(Projections.excludeId());
      return this;
    }

    /**
     * Creates a computed projections field.
     * <p>
     * WARNING: This projection is introduced in the aggregate only
     * when {@link #consolidateProjection()} method is called
     *
     * @param fieldName computed field name
     * @param expression expression to calculate field value
     * @return same instance
     */
    public Builder computed(String fieldName, Document expression) {
      projectionPieces.add(Projections.computed(fieldName, expression));
      return this;
    }

    /**
     * Uses all the previously introduced projections to create a new
     * projection aggregate and cleans up the existing projections.
     *
     * @return this same instance
     */
    public Builder consolidateProjection() {
      if (!projectionPieces.isEmpty()) {
        aggregations.add(Aggregates.project(Projections.fields(projectionPieces)));
        projectionPieces = new ArrayList<>();
      }
      return this;
    }
  }
}
