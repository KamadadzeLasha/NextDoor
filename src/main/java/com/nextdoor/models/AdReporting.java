package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdReporting extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("download_url")
    private String downloadUrl;

    public AdReporting() {

    }

    public AdReporting(String id, String advertiserId, String name, String downloadUrl) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.name = name;
        this.downloadUrl = downloadUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        return "AdReporting{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", name='" + name + '\'' +
                ", downloadUrl='" + downloadUrl + '\'' +
                '}';
    }
}