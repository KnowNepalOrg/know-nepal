package com.knownepal.destinations.common;

public final class Constants {

    private Constants() {
    }

    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";
    public static final String SLUG_REGEX = "^[a-z0-9]+(?:-[a-z0-9]+)*$";
}
