package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ad extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("adgroup_id")
    private String adGroupId;

    @JsonProperty("creative_id")
    private String creativeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("status")
    private String status;

    @JsonProperty("user_status")
    private String userStatus;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    public Ad() {

    }

    public Ad(String id, String advertiserId, String adGroupId, String creativeId, String name, String status, String userStatus, String createdAt, String updatedAt) {
        this.id = id;
        this.advertiserId = advertiserId;
        this.adGroupId = adGroupId;
        this.creativeId = creativeId;
        this.name = name;
        this.status = status;
        this.userStatus = userStatus;
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

    public String getAdGroupId() {
        return adGroupId;
    }

    public void setAdGroupId(String adGroupId) {
        this.adGroupId = adGroupId;
    }

    public String getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(String creativeId) {
        this.creativeId = creativeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
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
        return "Ad{" +
                "id='" + id + '\'' +
                ", advertiserId='" + advertiserId + '\'' +
                ", adGroupId='" + adGroupId + '\'' +
                ", creativeId='" + creativeId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public static Ad findById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIFindAdById(nextDoorAPIAuth, id).execute();
    }

    static class NextDoorAPIFindAdById extends NextDoorAPIRequest<Ad> implements NextDoorAPIExecute<Ad> {
        private final String id;

        public NextDoorAPIFindAdById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(Ad.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "ad/get/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Ad execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AdGroup.NextDoorAPIFindAdGroupById.AdGroupNotFoundException("Cannot find Ad group with id: " + this.id + " because of: " + e.getLocalizedMessage());
            }
        }
    }
}