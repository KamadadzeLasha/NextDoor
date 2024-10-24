package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;
import java.util.Date;

public class Campaign extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    private String id;

    @JsonProperty("advertiser_id")
    private String advertiserId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("objective")
    private String objective;

    @JsonProperty("status")
    private String status;

    @JsonProperty("user_status")
    private UserStatus userStatus;

    @JsonProperty("start_time")
    private Date startTime;

    @JsonProperty("end_time")
    private Date endTime;

    public Campaign() {

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

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public enum Objective {
        AWARENESS,
        CONSIDERATION
    }

    public enum UserStatus {
        ACTIVE,
        PAUSED,
        ARCHIVED
    }

    public static Campaign findById(String id, NextDoorAPIAuth nextDoorAPIAuth) throws APIRequestException {
        return new NextDoorAPIFindCampaignById(nextDoorAPIAuth, id).execute();
    }

    static class NextDoorAPIFindCampaignById extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private final String id;

        public NextDoorAPIFindCampaignById(NextDoorAPIAuth nextDoorAPIAuth, String id) {
            super(Campaign.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            NextDoorUtil.ensureStringNotNull(id, "id");
            this.id = id;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/get/" + this.id;
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public Campaign execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new CampaignNotFoundException("Can't find campaign by id " + this.id + " because of: " + e.getLocalizedMessage());
            }
        }

        public static class CampaignNotFoundException extends APIRequestException {
            public CampaignNotFoundException() {
            }

            public CampaignNotFoundException(String s) {
                super(s);
            }

            public CampaignNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public CampaignNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
