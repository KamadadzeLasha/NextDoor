package com.nextdoor.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BadRequestResponse {
    @JsonProperty("api_error_code")
    private String apiErrorCode;
    @JsonProperty("message")
    private String message;

    public BadRequestResponse() {

    }

    public BadRequestResponse(String apiErrorCode, String message) {
        this.apiErrorCode = apiErrorCode;
        this.message = message;
    }

    public String getApiErrorCode() {
        return apiErrorCode;
    }

    public void setApiErrorCode(String apiErrorCode) {
        this.apiErrorCode = apiErrorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BadRequest{" +
                "apiErrorCode='" + apiErrorCode + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
