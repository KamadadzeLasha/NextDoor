package com.nextdoor.models.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPostsBySignals extends NextDoorModel implements Serializable {
    @JsonProperty("posts")
    private List<SignalPost> posts;

    public static class SignalPost extends SearchPost implements Serializable {

    }
}
