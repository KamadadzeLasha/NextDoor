package com.nextdoor.models;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.exception.HTTPRequestNotSupportedException;

public enum ConversionType {
    NONE,
    JSON,
    URL_ENCODED;

    public static ConversionType fromHTTPMethod(HttpMethod httpMethod) throws HTTPRequestNotSupportedException {
        switch (httpMethod) {
            case GET:
                return NONE;
            case DELETE:
            case POST:
            case PUT:
                return JSON;
            default:
                throw new HTTPRequestNotSupportedException("HTTP request not supported: " + httpMethod);
        }
    }
}
