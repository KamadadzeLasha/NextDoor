package com.nextdoor.impl.advertise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.api.share.NextDoorAPIRequest;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.CampaignCreationException;
import com.nextdoor.models.Campaign;

public class NextDoorAPICampaign extends NextDoorAPIRequestNode {
    protected String advertiserId;

    public NextDoorAPICampaign() {

    }

    public NextDoorAPICampaign(String advertiserId, NextDoorAPIAuth nextDoorAPIAuth) {
        super();
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

            try {
                return sendPostRequest(DefaultURLS.DEFAULT_FULL_API_URL + "campaign/create");
            } catch (UnirestException | JsonProcessingException | APIRequestException e) {
                throw new CampaignCreationException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }
    }
}