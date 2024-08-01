package com.nextdoor.internal;

import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    public HttpResponse<JsonNode> sendPostRequest(String url, String body, Map<String, String> headers) throws UnirestException {
        Map<String, String> allHeaders = new HashMap<>(headers);
        allHeaders.putAll(this.getDefaultHeadersForPostRequest());

        return Unirest.post(url)
                .headers(allHeaders)
                .body(body)
                .asJson();
    }

    public HttpResponse<JsonNode> sendGetRequest(String url, Map<String, String> headers) throws UnirestException {
        Map<String, String> allHeaders = new HashMap<>(headers);
        allHeaders.putAll(this.getDefaultHeadersForGetRequest());

        return Unirest.get(url)
                .headers(allHeaders)
                .asJson();
    }

    private Map<String, String> getDefaultHeadersForGetRequest() {
        Map<String, String> headers = new HashMap<>();

        headers.put("accept", "application/json");

        return headers;
    }

    private Map<String, String> getDefaultHeadersForPostRequest() {
        Map<String, String> headers = new HashMap<>();

        headers.put("accept", "application/json");
        headers.put("content-type", "application/json");

        return headers;
    }
}