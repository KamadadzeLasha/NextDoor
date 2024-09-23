package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdFile extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("file_name")
    private String fileName;

    @JsonProperty("public_url")
    private String publicUrl;

    @JsonProperty("mime_type")
    private String mimeType;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public AdFile() {

    }

    public AdFile(String id, String advertiserId, String fileName, String publicUrl, String mimeType, String createdAt, String updatedAt) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.fileName = fileName;
        this.publicUrl = publicUrl;
        this.mimeType = mimeType;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPublicUrl() {
        return publicUrl;
    }

    public void setPublicUrl(String publicUrl) {
        this.publicUrl = publicUrl;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "AdFile{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", publicUrl='" + publicUrl + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}