package com.nextdoor.internal;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    public HttpResponse<JsonNode> sendPostRequest(String url, String body, Map<String, String> headers) throws UnirestException {
        return Unirest.post(url)
                .headers(this.getDefaultHeadersForPostRequest())
                .headers(headers)
                .body(body)
                .asJson();
    }

    private Map<String, String> getDefaultHeadersForPostRequest() {
        Map<String, String> headers = new HashMap<>();

        headers.put("accept", "application/json");
        headers.put("content-type", "application/json");

        return headers;
    }
}