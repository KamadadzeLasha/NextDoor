package com.nextdoor.constants;

public class DefaultURLS {
    public static final String DEFAULT_URL = "https://ads.nextdoor.com/";
    public static final String AUTH_URL = "https://auth.nextdoor.com/";
    public static final String DEFAULT_VERSION = "v2";
    public static final String DEFAULT_API_PREFIX = "api";
    public static final String DEFAULT_FULL_API_URL;
    public static final String DEFAULT_AUTH_FULL_API_URL;

    static {
        String SLASH = "/";
        DEFAULT_FULL_API_URL = DEFAULT_URL + DEFAULT_VERSION + SLASH + DEFAULT_API_PREFIX + SLASH;
        DEFAULT_AUTH_FULL_API_URL = AUTH_URL + DEFAULT_VERSION + SLASH;
    }
}
