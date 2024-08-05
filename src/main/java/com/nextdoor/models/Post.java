package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Post extends NextDoorModel implements Serializable {
    @JsonProperty("result")
    private String result;

    @JsonProperty("share_link")
    private String linkToPost;

    public Post() {

    }

    public Post(String result, String linkToPost) {
        this.result = result;
        this.linkToPost = linkToPost;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLinkToPost() {
        return linkToPost;
    }

    public void setLinkToPost(String linkToPost) {
        this.linkToPost = linkToPost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "result='" + result + '\'' +
                ", linkToPost='" + linkToPost + '\'' +
                '}';
    }
}
