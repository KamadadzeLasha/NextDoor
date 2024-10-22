package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvertiserCampaign extends NextDoorModel implements Serializable {
    @JsonProperty("campaigns")
    private List<Campaign> campaigns;

    @JsonProperty("page_info")
    private Pagination pageInfo;

    public AdvertiserCampaign() {

    }

    public AdvertiserCampaign(List<Campaign> campaigns, Pagination pageInfo) {
        this.campaigns = campaigns;
        this.pageInfo = pageInfo;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public Pagination getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Campaign implements Serializable {

        private static final long serialVersionUID = 1L;

        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private CampaignData data;

        public Campaign() {

        }

        public Campaign(String cursor, CampaignData data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public CampaignData getData() {
            return data;
        }

        public void setData(CampaignData data) {
            this.data = data;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CampaignData implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("advertiser_id")
        private String advertiserId;

        @JsonProperty("name")
        private String name;

        @JsonProperty("status")
        private String status;

        @JsonProperty("user_status")
        private String userStatus;

        @JsonProperty("objective")
        private String objective;

        @JsonProperty("created_at")
        private Instant createdAt;

        @JsonProperty("updated_at")
        private Instant updatedAt;

        @JsonProperty("start_time")
        private ZonedDateTime startTime;

        @JsonProperty("end_time")
        private ZonedDateTime endTime;

        public CampaignData() {

        }

        public CampaignData(String id, String advertiserId, String name, String status, String userStatus, String objective, Instant createdAt, Instant updatedAt, ZonedDateTime startTime, ZonedDateTime endTime) {
            this.id = id;
            this.advertiserId = advertiserId;
            this.name = name;
            this.status = status;
            this.userStatus = userStatus;
            this.objective = objective;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.startTime = startTime;
            this.endTime = endTime;
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

        public String getObjective() {
            return objective;
        }

        public void setObjective(String objective) {
            this.objective = objective;
        }

        public Instant getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Instant createdAt) {
            this.createdAt = createdAt;
        }

        public Instant getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Instant updatedAt) {
            this.updatedAt = updatedAt;
        }

        public ZonedDateTime getStartTime() {
            return startTime;
        }

        public void setStartTime(ZonedDateTime startTime) {
            this.startTime = startTime;
        }

        public ZonedDateTime getEndTime() {
            return endTime;
        }

        public void setEndTime(ZonedDateTime endTime) {
            this.endTime = endTime;
        }
    }
}