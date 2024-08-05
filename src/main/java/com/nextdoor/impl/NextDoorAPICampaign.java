package com.nextdoor.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.api.share.NextDoorAPICreate;
import com.nextdoor.api.share.NextDoorAPIRequest;
import com.nextdoor.api.share.NextDoorAPIUpdate;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.CampaignCreationException;
import com.nextdoor.exception.CampaignUpdateException;
import com.nextdoor.models.Campaign;
import com.nextdoor.models.ConversionType;
import com.nextdoor.util.NextDoorUtil;

public class NextDoorAPICampaign extends NextDoorAPIRequestNode {
    protected String advertiserId;

    public NextDoorAPICampaign() {

    }

    public NextDoorAPICampaign(String advertiserId, NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);

        NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public NextDoorAPICreateCampaign createCampaign() {
        return new NextDoorAPICreateCampaign(nextDoorAPIAuth, this);
    }

    public NextDoorAPIUpdateCampaign updateCampaign(String campaignId) {
        return new NextDoorAPIUpdateCampaign(nextDoorAPIAuth, this, campaignId);
    }

    public static class NextDoorAPICreateCampaign extends NextDoorAPIRequest<Campaign> implements NextDoorAPICreate<Campaign> {
        private final NextDoorAPICampaign nextDoorAPICampaign;

        public NextDoorAPICreateCampaign(NextDoorAPIAuth nextDoorAPIAuth, NextDoorAPICampaign nextDoorAPICampaign) {
            super(Campaign.class, nextDoorAPIAuth);
            this.nextDoorAPICampaign = nextDoorAPICampaign;
        }

        public NextDoorAPICreateCampaign setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateCampaign setObjective(Campaign.Objective objective) {
            this.setParamInternal("objective", objective.name());

            return this;
        }

        @Override
        public Campaign create() throws CampaignCreationException {
            this.setParamInternal("advertiser_id", nextDoorAPICampaign.advertiserId);
            this.addHeader(nextDoorAPICampaign.nextDoorAPIAuth.getTokenHeader());

            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, getPath(), ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignCreationException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_API_URL + "campaign/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("name"), "name");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("objective"), "objective");
        }
    }

    public static class NextDoorAPIUpdateCampaign extends NextDoorAPIRequest<Campaign> implements NextDoorAPIUpdate<Campaign> {
        private final NextDoorAPICampaign nextDoorAPICampaign;
        private final String campaignId;

        public NextDoorAPIUpdateCampaign(NextDoorAPIAuth nextDoorAPIAuth, NextDoorAPICampaign nextDoorAPICampaign, String campaignId) {
            super(Campaign.class, nextDoorAPIAuth);

            this.nextDoorAPICampaign = nextDoorAPICampaign;
            this.campaignId = campaignId;
        }

        public NextDoorAPIUpdateCampaign setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIUpdateCampaign setObjective(Campaign.Objective objective) {
            this.setParamInternal("objective", objective.name());

            return this;
        }

        public NextDoorAPIUpdateCampaign setUserStatus(Campaign.UserStatus userStatus) {
            this.setParamInternal("user_status", userStatus.name());

            return this;
        }

        @Override
        public Campaign update() throws CampaignUpdateException {
            this.setParamInternal("advertiser_id", this.nextDoorAPICampaign.advertiserId);
            this.setParamInternal("id", this.campaignId);

            validateRequiredParams();

            this.addHeader(this.nextDoorAPICampaign.nextDoorAPIAuth.getTokenHeader());

            try {
                if (this.containsParamInternal("user_status") && !this.containsParamInternal("objective")) {
                    validateParams("user_status");
                    return sendHttpRequest(HttpMethod.POST, updateStatusPath(), ConversionType.JSON);
                } else if (!this.containsParamInternal("user_status") && this.containsParamInternal("objective")) {
                    validateParams("objective");
                    validateParams("name");

                    return sendHttpRequest(HttpMethod.POST, getPath(), ConversionType.JSON);
                }

                validateParams("objective");
                validateParams("name");
                validateParams("user_status");

                sendHttpRequest(HttpMethod.POST, getPath(), ConversionType.JSON);
                return sendHttpRequest(HttpMethod.POST, updateStatusPath(), ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignUpdateException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_API_URL + "campaign/update";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("id"), "id");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("advertiser_id"), "id");
        }

        private String updateStatusPath() {
            return DefaultURLS.DEFAULT_FULL_API_URL + "campaign/status/update";
        }
    }
}