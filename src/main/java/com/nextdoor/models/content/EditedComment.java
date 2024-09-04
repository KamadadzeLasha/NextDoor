package com.nextdoor.models.content;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;

public class EditedComment extends NextDoorModel implements Serializable {
    @JsonProperty("result")
    private String result;

    public EditedComment() {

    }

    public EditedComment(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "EditedComment{" +
                "result='" + result + '\'' +
                '}';
    }
}
