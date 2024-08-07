package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class DeletedModel extends NextDoorModel implements Serializable {
    @JsonProperty("message")
    private String message;

    public DeletedModel() {

    }

    public DeletedModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DeletedModel{" +
                "message='" + message + '\'' +
                '}';
    }
}
