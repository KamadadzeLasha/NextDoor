package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPostsBySignals extends NextDoorModel implements Serializable {
    @JsonProperty("posts")
    private List<SignalPost> posts;

    public static class SignalPost extends SearchPost implements Serializable {

    }
}
