package com.nextdoor.share;

import com.nextdoor.util.NextDoorUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public abstract class NextDoorAPIRequestData {
    private static final String UTF_8 = "UTF-8";

    private Map<String, Object> params = new HashMap<>();
    private Map<String, String> additionalHeaders = new HashMap<>();
    private Map<String, String> queryString = new HashMap<>();

    public Map<String, Object> getParams() {
        return params;
    }

    public Map<String, String> getAdditionalHeaders() {
        return additionalHeaders;
    }

    public Map<String, String> getQueryString() {
        return queryString;
    }

    public void addHeader(String key, String value) {
        this.additionalHeaders.put(key, value);
    }

    public void setParamInternal(String param, Object value) {
        this.params.put(param, value);
    }

    protected void setParamInternal(Map<String, Object> params) {
        this.params.putAll(params);
    }

    protected void writeParamInternal(Map<String, Object> params) {
        this.params = params;
    }

    protected boolean containsParamInternal(String param) {
        return this.params.containsKey(param);
    }

    protected void removeParamInternal(String param) {
        this.params.remove(param);
    }

    protected Object getParamInternal(String param) {
        return this.params.get(param);
    }

    protected void addHeader(Map<String, String> additionalHeaders) {
        this.additionalHeaders.putAll(additionalHeaders);
    }

    protected void writeHeader(Map<String, String> additionalHeaders) {
        this.additionalHeaders = additionalHeaders;
    }

    protected void addParameters(String key, String value) {
        this.queryString.put(key, value);
    }

    protected void addParameters(Map<String, String> queryString) {
        this.queryString.putAll(queryString);
    }

    protected void writeParameters(Map<String, String> queryString) {
        this.queryString = queryString;
    }

    protected boolean existsParam(String key) {
        return this.queryString.containsKey(key);
    }

    protected void replaceParam(String key, String value) {
        this.queryString.replace(key, value);
    }

    protected void checkAndReplaceOrAddParameter(String key, String value) {
        if (this.existsParam(key)) {
            this.replaceParam(key, value);
            return;
        }

        this.addParameters(key, value);
    }

    protected void validateParams(String... params) {
        for (String param : params) {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal(param), param);
        }
    }

    protected void clearAllMaps() {
        this.params.clear();
        this.additionalHeaders.clear();
        this.queryString.clear();
    }

    protected String setQueryStrings(String url) throws UnsupportedEncodingException {
        StringBuilder urlWithParams = new StringBuilder(url);

        if (!this.queryString.isEmpty()) {
            urlWithParams.append("?");
            for (Map.Entry<String, String> entry : this.queryString.entrySet()) {
                urlWithParams
                        .append(URLEncoder.encode(entry.getKey(), UTF_8))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), UTF_8))
                        .append("&");
            }

            // Remove the last '&' character
            urlWithParams.deleteCharAt(urlWithParams.length() - 1);
        }

        return urlWithParams.toString();
    }

    protected String toUrlEncodedString(Map<String, Object> map) throws UnsupportedEncodingException {
        StringJoiner stringJoiner = new StringJoiner("&");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            stringJoiner.add(URLEncoder.encode(entry.getKey(), UTF_8) + "=" + URLEncoder.encode(entry.getValue().toString(), UTF_8));
        }
        return stringJoiner.toString();
    }
}