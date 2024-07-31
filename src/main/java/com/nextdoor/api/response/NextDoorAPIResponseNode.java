package com.nextdoor.api.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextdoor.auth.NextDoorAPIAuth;

public abstract class NextDoorAPIResponseNode implements NextDoorAPIResponse {
    protected NextDoorAPIAuth nextDoorAPIAuth;
    protected String objAsString;
    private ObjectMapper objectMapper = new ObjectMapper();

    public NextDoorAPIResponseNode(String token) {
        this.nextDoorAPIAuth = new NextDoorAPIAuth(token);
    }

    public NextDoorAPIResponseNode(NextDoorAPIAuth nextDoorAPIAuth) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }

    public NextDoorAPIResponseNode(NextDoorAPIAuth nextDoorAPIAuth, String objAsString) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
        this.objAsString = objAsString;
    }

    public NextDoorAPIResponseNode(ObjectMapper objectMapper, NextDoorAPIAuth nextDoorAPIAuth, String objAsString) {
        this.objectMapper = objectMapper;
        this.nextDoorAPIAuth = nextDoorAPIAuth;
        this.objAsString = objAsString;
    }

    public NextDoorAPIAuth getNextDoorAPIAuth() {
        return nextDoorAPIAuth;
    }

    public void setNextDoorAPIAuth(NextDoorAPIAuth nextDoorAPIAuth) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }

    public void setObjAsString(String objAsString) {
        this.objAsString = objAsString;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonNode parseAsJsonNode() throws JsonProcessingException {
        return objectMapper.readTree(this.objAsString);
    }

    @Override
    public String getObjAsString() {
        return this.objAsString;
    }
}
