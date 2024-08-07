package com.nextdoor.share;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.HTTPRequestFailureException;
import com.nextdoor.exception.HTTPRequestNotSupportedException;
import com.nextdoor.internal.DataParser;
import com.nextdoor.internal.HttpClient;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.NextDoorModel;

import java.io.UnsupportedEncodingException;

public abstract class NextDoorAPIRequest<T extends NextDoorModel> extends NextDoorAPIRequestData {
    private final DataParser dataParser = new DataParser();
    private final HttpClient httpClient = new HttpClient();
    private final NextDoorAPIAuth nextDoorAPIAuth;
    private final Class<T> responseClass;

    public NextDoorAPIRequest(Class<T> responseClass, NextDoorAPIAuth nextDoorAPIAuth) {
        this.responseClass = responseClass;
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }

    public NextDoorAPIAuth getNextDoorAPIAuth() {
        return nextDoorAPIAuth;
    }

    protected T sendHttpRequest(HttpMethod httpMethod) throws APIRequestException {
        return sendHttpRequest(httpMethod, getPath());
    }

    protected T sendHttpRequest(HttpMethod httpMethod, ConversionType conversionType) throws APIRequestException {
        return sendHttpRequest(httpMethod, getPath(), conversionType);
    }

    protected T sendHttpRequest(HttpMethod httpMethod, String path) throws APIRequestException {
        switch (httpMethod) {
            case GET:
                return sendHttpRequest(httpMethod, path, null);
            case DELETE:
            case POST:
            case PUT:
                return sendHttpRequest(httpMethod, path, ConversionType.JSON);
            default:
                throw new HTTPRequestNotSupportedException("HTTP request not supported: " + httpMethod);
        }
    }

    //TODO: Refactor method -- ??
    protected T sendHttpRequest(HttpMethod httpMethod, String path, ConversionType conversionType) throws APIRequestException {
        nextDoorAPIAuth.log("======================= NEXTDOOR API {0} START =======================", httpMethod);

        String fullUrl;
        try {
            fullUrl = setQueryStrings(path);
        } catch (UnsupportedEncodingException e) {
            throw new APIRequestException(e);
        }
        nextDoorAPIAuth.log("Sending HTTP {0} request to {1}", httpMethod, fullUrl);

        HttpResponse<JsonNode> response = getHttpResponseJsonNode(httpMethod, fullUrl, conversionType);

        this.clearAllMaps();

        int status = response.getStatus();
        nextDoorAPIAuth.log("HTTP Request sended with status {0}", status);

        String responseJsonAsString = response.getBody().toString();

        if (status != 200) {
            nextDoorAPIAuth.log("======================= NEXTDOOR API {0} FAILED =======================", httpMethod);
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + responseJsonAsString);
        }

        nextDoorAPIAuth.log("Ended successfully, converting to JSON {0}", responseJsonAsString);
        nextDoorAPIAuth.log("======================= NEXTDOOR API {0} ENDED SUCCESSFULLY =======================", httpMethod);
        try {
            return dataParser.parseToObject(responseJsonAsString, responseClass);
        } catch (DataParser.DataParserException e) {
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + e.getLocalizedMessage());
        }
    }

    private HttpResponse<JsonNode> getHttpResponseJsonNode(HttpMethod httpMethod, String path, ConversionType conversionType) throws HTTPRequestFailureException {
        try {
            switch (httpMethod) {
                case DELETE:
                case PUT:
                case POST: {
                    addAdditionalPostRequestHeaders(conversionType);
                    return httpClient.sendPostRequest(path, getBody(conversionType), this.getAdditionalHeaders());
                }
                case GET:
                    return httpClient.sendGetRequest(path, this.getAdditionalHeaders());
                default:
                    throw new RuntimeException("Unsupported HTTP method");
            }
        } catch (UnirestException | RuntimeException | UnsupportedEncodingException |
                 DataParser.DataParserException e) {
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + e.getLocalizedMessage());
        }
    }

    private void addAdditionalPostRequestHeaders(ConversionType conversionType) {
        this.getAdditionalHeaders().putAll(httpClient.getHeadersByConversionType(conversionType));
    }

    private String getBody(ConversionType conversionType) throws UnsupportedEncodingException, DataParser.DataParserException {
        switch (conversionType) {
            case URL_ENCODED:
                return this.toUrlEncodedString(this.getParams());
            case JSON:
                return this.dataParser.convertObjectToJsonString(this.getParams());
        }

        return null;
    }

    protected abstract String getPath();

    protected abstract void validateRequiredParams();
}
