package com.nextdoor.api.share;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.HTTPRequestFailureException;
import com.nextdoor.internal.HttpClient;
import com.nextdoor.util.NextDoorUtil;

import java.util.HashMap;
import java.util.Map;

public abstract class NextDoorAPIRequest<T extends NextDoorAPIRequestNode> {
    private Map<String, Object> params = new HashMap<>();
    private Map<String, String> additionalHeaders = new HashMap<>();

    private ObjectMapper objectMapper = new ObjectMapper();
    private final HttpClient httpClient = new HttpClient();
    private final NextDoorAPIAuth nextDoorAPIAuth;
    private final Class<T> responseClass;

    public NextDoorAPIRequest(Class<T> responseClass, NextDoorAPIAuth nextDoorAPIAuth) {
        this.responseClass = responseClass;
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void setParamInternal(String param, Object value) {
        this.params.put(param, value);
    }

    public void setParamInternal(Map<String, Object> params) {
        this.params.putAll(params);
    }

    public void writeParamInternal(Map<String, Object> params) {
        this.params = params;
    }

    public boolean containsParamInternal(String param) {
        return this.params.containsKey(param);
    }

    public void removeParamInternal(String param) {
        this.params.remove(param);
    }

    public Object getParamInternal(String param) {
        return this.params.get(param);
    }

    public void addHeader(String key, String value) {
        this.additionalHeaders.put(key, value);
    }

    public void addHeader(Map<String, String> additionalHeaders) {
        this.additionalHeaders.putAll(additionalHeaders);
    }

    public void writeHeader(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }

    protected T sendHttpRequest(HttpMethod httpMethod) throws APIRequestException {
        return sendHttpRequest(httpMethod, getPath());
    }

    protected T sendHttpRequest(HttpMethod httpMethod, String path) throws APIRequestException {
        nextDoorAPIAuth.log("======================= NEXTDOOR API {0} START =======================", httpMethod);

        nextDoorAPIAuth.log("Sending HTTP {0} request to {1}", httpMethod, path);

        HttpResponse<JsonNode> response = getHttpResponseJsonNode(httpMethod, path);

        params.clear();
        additionalHeaders.clear();

        int status = response.getStatus();
        nextDoorAPIAuth.log("HTTP Request sended with status {0}", status);

        JsonNode jsonNodeBody = response.getBody();
        String body = jsonNodeBody.getObject().get("message").toString();

        if (status != 200) {
            nextDoorAPIAuth.log("======================= NEXTDOOR API {0} FAILED =======================", httpMethod);
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + body);
        }

        nextDoorAPIAuth.log("Ended successfully, converting to JSON {0}", jsonNodeBody.toString());
        nextDoorAPIAuth.log("======================= NEXTDOOR API {0} ENDED SUCCESSFULLY =======================", httpMethod);
        try {
            return objectMapper.readValue(body, responseClass);
        } catch (JsonProcessingException e) {
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + e.getLocalizedMessage());
        }
    }

    private HttpResponse<JsonNode> getHttpResponseJsonNode(HttpMethod httpMethod, String path) throws HTTPRequestFailureException {
        try {
            switch (httpMethod) {
                case POST:
                    return httpClient.sendPostRequest(path, objectMapper.writeValueAsString(this.params), additionalHeaders);
                case GET:
                    return httpClient.sendGetRequest(path, additionalHeaders);
                default:
                    throw new RuntimeException("Unsupported HTTP method");
            }
        } catch (UnirestException | JsonProcessingException | RuntimeException e) {
            throw new HTTPRequestFailureException("HTTP " + httpMethod + " request failed " + e.getLocalizedMessage());
        }
    }

    protected void validateParams(String... params) {
        for (String param : params) {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal(param), param);
        }
    }

    protected abstract String getPath();

    protected abstract void validateRequiredParams();
}
