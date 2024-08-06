package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.share.NextDoorAPIRequest;
import com.nextdoor.share.NextDoorAPIUpdateEdit;
import com.nextdoor.util.NextDoorUtil;

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

    public static PostEdit edit(String postId, NextDoorAPIAuth nextDoorAPIAuth) {
        return new PostEdit(postId, nextDoorAPIAuth);
    }

    public static class PostEdit extends NextDoorAPIRequest<Post> implements NextDoorAPIUpdateEdit<Post> {
        private final String postId;

        public PostEdit(String postId, NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(postId, "postId");
            this.postId = postId;
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Post update() throws APIRequestException {
            return null;
        }
    }
}
