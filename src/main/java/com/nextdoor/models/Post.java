package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.api.NextDoorAPIPosts;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Posts.ExistedPost fetchById(String postId, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        Posts posts = new NextDoorAPIPosts(nextDoorAPIAuth).getAllPosts().get();
        List<Posts.ExistedPost> filteredPost = posts.getPosts()
                .stream()
                .filter(elem -> elem.getId().equals(postId)).collect(Collectors.toList());

        if (filteredPost.isEmpty()) {
            throw new APIRequestException("No post with id " + postId + " found");
        }

        return filteredPost.get(0);
    }
}
