package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Profiles extends NextDoorModel implements Serializable {
    @JsonProperty("primary_profile_id")
    private String primaryProfileId;

    @JsonProperty("profile_list")
    private List<Profile> profileList;

    public Profiles() {

    }

    public Profiles(String primaryProfileId, List<Profile> profileList) {
        this.primaryProfileId = primaryProfileId;
        this.profileList = profileList;
    }

    public String getPrimaryProfileId() {
        return primaryProfileId;
    }

    public void setPrimaryProfileId(String primaryProfileId) {
        this.primaryProfileId = primaryProfileId;
    }

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    @Override
    public String toString() {
        return "Profiles{" +
                "primaryProfileId='" + primaryProfileId + '\'' +
                ", profileList=" + profileList +
                '}';
    }
}
