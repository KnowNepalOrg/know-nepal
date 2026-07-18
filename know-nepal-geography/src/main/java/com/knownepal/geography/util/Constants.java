package com.knownepal.geography.util;

public final class Constants {

    private Constants() {
    }

    public static final String API_V1 = "/api/v1";
    public static final String PROVINCES = API_V1 + "/provinces";
    public static final String DISTRICTS = API_V1 + "/districts";
    public static final String MUNICIPALITIES = API_V1 + "/municipalities";
    public static final String WARDS = API_V1 + "/wards";
    public static final String EMERGENCY_CONTACTS = API_V1 + "/emergency-contacts";
    public static final String SEARCH = API_V1 + "/search";

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    public static final String SLUG_PATTERN = "^[a-z0-9]+(?:-[a-z0-9]+)*$";
}
