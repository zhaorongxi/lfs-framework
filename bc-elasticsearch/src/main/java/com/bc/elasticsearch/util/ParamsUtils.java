package com.bc.elasticsearch.util;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.lang.NonNull;

/**
 * @author xuy99
 */
public class ParamsUtils {

    public static BoolQueryBuilder getBoolQueryBuilder() {
        return QueryBuilders.boolQuery();
    }


    public static BoolQueryBuilder eq(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object value) {
        return queryBuilder.must(QueryBuilders.termQuery(field, value));
    }

    public static BoolQueryBuilder prefix(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull String value) {
        return queryBuilder.must(QueryBuilders.prefixQuery(field, value));
    }


    public static BoolQueryBuilder not(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object value) {
        return queryBuilder.mustNot(QueryBuilders.termQuery(field, value));
    }


    public static BoolQueryBuilder or(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object value) {
        return queryBuilder.should(QueryBuilders.matchQuery(field, value).operator(Operator.OR));
    }

    public static BoolQueryBuilder gt(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object value) {
        return queryBuilder.must(QueryBuilders.rangeQuery(field).gt(value));
    }

    public static BoolQueryBuilder gte(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object value) {
        return queryBuilder.must(QueryBuilders.rangeQuery(field).gte(value));
    }


    public static BoolQueryBuilder lt(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object value) {
        return queryBuilder.must(QueryBuilders.rangeQuery(field).lt(value));
    }

    public static BoolQueryBuilder lte(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object value) {
        return queryBuilder.must(QueryBuilders.rangeQuery(field).lte(value));
    }


    public static BoolQueryBuilder in(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object... value) {
        return queryBuilder.must(QueryBuilders.termsQuery(field, value));
    }


    public static BoolQueryBuilder notIn(BoolQueryBuilder queryBuilder, @NonNull String field, @NonNull Object... value) {
        return queryBuilder.mustNot(QueryBuilders.termsQuery(field, value));
    }

}
