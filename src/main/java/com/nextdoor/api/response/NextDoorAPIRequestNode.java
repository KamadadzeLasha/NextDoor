package com.nextdoor.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextdoor.auth.NextDoorAPIAuth;

public abstract class NextDoorAPIRequestNode implements NextDoorAPIResponse {
    @JsonIgnore
    protected NextDoorAPIAuth nextDoorAPIAuth;
    @JsonIgnore
    protected String objAsString;
    @JsonIgnore
    private ObjectMapper objectMapper = new ObjectMapper();

    public NextDoorAPIRequestNode(String token) {
        this.nextDoorAPIAuth = new NextDoorAPIAuth(token);
    }

    public NextDoorAPIRequestNode(NextDoorAPIAuth nextDoorAPIAuth) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }

    public NextDoorAPIRequestNode(NextDoorAPIAuth nextDoorAPIAuth, String objAsString) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
        this.objAsString = objAsString;
    }

    public NextDoorAPIRequestNode(ObjectMapper objectMapper, NextDoorAPIAuth nextDoorAPIAuth, String objAsString) {
        this.objectMapper = objectMapper;
        this.nextDoorAPIAuth = nextDoorAPIAuth;
        this.objAsString = objAsString;
    }

    @JsonIgnore
    public NextDoorAPIAuth getNextDoorAPIAuth() {
        return nextDoorAPIAuth;
    }

    public void setNextDoorAPIAuth(NextDoorAPIAuth nextDoorAPIAuth) {
        this.nextDoorAPIAuth = nextDoorAPIAuth;
    }

    public void setObjAsString(String objAsString) {
        this.objAsString = objAsString;
    }

    @JsonIgnore
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
