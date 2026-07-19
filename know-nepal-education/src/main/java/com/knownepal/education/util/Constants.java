package com.knownepal.education.util;

public final class Constants {

    private Constants() {
    }

    public static final String API_V1 = "/api/v1";
    public static final String SCHOOLS = API_V1 + "/schools";
    public static final String COLLEGES = API_V1 + "/colleges";
    public static final String UNIVERSITIES = API_V1 + "/universities";
    public static final String PROGRAMS = API_V1 + "/programs";
    public static final String SEARCH = API_V1 + "/search";

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    public static final String SLUG_PATTERN = "^[a-z0-9]+(?:-[a-z0-9]+)*$";
}
