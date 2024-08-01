package com.nextdoor.api.share;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.BadRequestResponse;

import java.util.HashMap;
import java.util.Map;

public abstract class NextDoorAPIRequest<T extends NextDoorAPIRequestNode> {
    private Map<String, Object> params = new HashMap<>();
    private Map<String, String> additionalHeaders = new HashMap<>();
    private ObjectMapper objectMapper = new ObjectMapper();
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

    public NextDoorAPIRequest<T> addHeader(String key, String value) {
        this.additionalHeaders.put(key, value);

        return this;
    }

    public NextDoorAPIRequest<T> addHeader(Map<String, String> additionalHeaders) {
        this.additionalHeaders.putAll(additionalHeaders);

        return this;
    }

    public NextDoorAPIRequest<T> writeHeader(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;

        return this;
    }

    public Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();

        headers.put("accept", "application/json");
        headers.put("content-type", "application/json");

        return headers;
    }

    protected T sendPostRequest() throws UnirestException, JsonProcessingException, APIRequestException {
        nextDoorAPIAuth.log("======================= NEXTDOOR API POST START =======================");
        String sendBody = objectMapper.writeValueAsString(this.params);
        nextDoorAPIAuth.log("Sending HTTP POST request to {0} with body {1}", getPath(), sendBody);

        HttpResponse<String> response = Unirest.post(getPath())
                .headers(this.getDefaultHeaders())
                .headers(nextDoorAPIAuth.getTokenHeader())
                .headers(additionalHeaders)
                .body(sendBody)
                .asString();

        int status = response.getStatus();
        nextDoorAPIAuth.log("HTTP Request sended with status {0}", status);

        String body = response.getBody();

        if (status != 200) {
            BadRequestResponse badRequestResponse = objectMapper.readValue(body, BadRequestResponse.class);
            nextDoorAPIAuth.log("======================= NEXTDOOR API POST FAILED =======================");
            throw new APIRequestException("HTTP POST request failed " + badRequestResponse.getMessage());
        }

        nextDoorAPIAuth.log("Ended successfully, converting to JSON {0}", body);
        nextDoorAPIAuth.log("======================= NEXTDOOR API POST ENDED SUCCESSFULLY =======================");
        return objectMapper.readValue(body, responseClass);
    }

    protected abstract String getPath();
}
