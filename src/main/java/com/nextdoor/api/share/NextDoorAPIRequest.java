package com.nextdoor.api.share;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.api.response.NextDoorAPIResponseNode;
import com.nextdoor.auth.NextDoorAPIAuth;

import java.util.HashMap;
import java.util.Map;

public abstract class NextDoorAPIRequest<T extends NextDoorAPIResponseNode> {
    private T obj;
    private ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> responseClass;

    public NextDoorAPIRequest(Class<T> responseClass) {
        this.responseClass = responseClass;
    }

    public NextDoorAPIRequest(T obj, Class<T> responseClass) {
        this.obj = obj;
        this.responseClass = responseClass;
    }

    public NextDoorAPIRequest(Class<T> responseClass, T obj, ObjectMapper objectMapper) {
        this.responseClass = responseClass;
        this.obj = obj;
        this.objectMapper = objectMapper;
    }

    public T getObj() {
        return ensureObjNotNull();
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Map<String, String> getDefaultHeaders() {
        Map<String, String> headers = new HashMap<>();

        headers.put("accept", "application/json");
        headers.put("content-type", "application/json");

        return headers;
    }

    protected T sendPostRequest(String URL, Map<String, String> headers, Class<T> classToParse) throws UnirestException, JsonProcessingException {
        NextDoorAPIAuth nextDoorAPIAuth = this.obj.getNextDoorAPIAuth();

        nextDoorAPIAuth.log("Sending HTTP POST request to " + URL);
        HttpResponse<String> response = Unirest.post(URL)
                .headers(this.getDefaultHeaders())
                .headers(nextDoorAPIAuth.getTokenHeader())
                .headers(headers)
                .body(this.obj.getObjAsString())
                .asString();
        int status = response.getStatus();
        nextDoorAPIAuth.log("HTTP Request sended with status " + status);
        if (status == 200) {
            nextDoorAPIAuth.log("Ended successfully, converting to JSON");
            return objectMapper.readValue(response.getBody(), classToParse);
        }

        //TODO: Refactor
        return null;
    }

    private T ensureObjNotNull() {
        //TODO: Maybe refactor

        if (this.obj == null) {
            try {
                this.obj = this.responseClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return this.obj;
    }

    public abstract String getAPIRequestPath();
}
