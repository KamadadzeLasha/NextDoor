package com.nextdoor.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.api.share.NextDoorAPIRequest;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.CampaignCreationException;
import com.nextdoor.models.Campaign;
import com.nextdoor.util.NextDoorUtil;

public class NextDoorAPICampaign extends NextDoorAPIRequestNode {
    protected String advertiserId;

    public NextDoorAPICampaign() {

    }

    public NextDoorAPICampaign(String advertiserId, NextDoorAPIAuth nextDoorAPIAuth) {
        super();
        NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");
        NextDoorUtil.ensureObjectNotNull(nextDoorAPIAuth, "nextDoorAPIAuth");

        this.advertiserId = advertiserId;
        this.nextDoorAPIAuth = nextDoorAPIAuth;
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

    public static class NextDoorAPICreateCampaign extends NextDoorAPIRequest<Campaign> {
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

        public Campaign execute() throws CampaignCreationException {
            this.setParamInternal("advertiser_id", nextDoorAPICampaign.advertiserId);
            this.addHeader(nextDoorAPICampaign.nextDoorAPIAuth.getTokenHeader());

            try {
                return sendPostRequest();
            } catch (UnirestException | JsonProcessingException | APIRequestException e) {
                throw new CampaignCreationException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_API_URL + "campaign/create";
        }
    }
}