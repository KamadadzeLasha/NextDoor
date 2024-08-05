package com.nextdoor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.CampaignCreationException;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws CampaignCreationException, JsonProcessingException, UnsupportedEncodingException {
        Map<String, Object> settings = new HashMap<>();
        settings.put("grant_type", "authorization_code");
        settings.put("code", "qwerty");
        settings.put("client_id", "123qweqwe");
        settings.put("redirect_uri", "www.google.com");
        ObjectMapper objectMapper = new ObjectMapper();
    }

    public static NextDoorAPIAuth getApiAuth() {
        NextDoorAPIAuth nextDoorAPIAuth = new NextDoorAPIAuth();
        nextDoorAPIAuth.setToken("your-token");
        nextDoorAPIAuth.enableDebug(true);

        return nextDoorAPIAuth;
    }
}
