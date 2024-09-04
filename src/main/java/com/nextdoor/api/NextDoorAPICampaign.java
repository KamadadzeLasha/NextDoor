package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Campaign;
import com.nextdoor.models.ConversionType;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.util.NextDoorUtil;

public class NextDoorAPICampaign extends NextDoorAPIRequestNode {
    protected String advertiserId;

    public NextDoorAPICampaign() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
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
        return new NextDoorAPICreateCampaign(this);
    }

    public NextDoorAPIUpdateCampaign updateCampaign(String campaignId) {
        return new NextDoorAPIUpdateCampaign(this, campaignId);
    }

    public static class NextDoorAPICreateCampaign extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private final NextDoorAPICampaign nextDoorAPICampaign;

        public NextDoorAPICreateCampaign(NextDoorAPICampaign nextDoorAPICampaign) {
            super(Campaign.class, nextDoorAPICampaign.getNextDoorAPIAuth());

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
        public Campaign execute() throws APIRequestException {
            this.setParamInternal("advertiser_id", nextDoorAPICampaign.getAdvertiserId());
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, getPath(), ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignCreationException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("advertiser_id"), "advertiser_id");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("name"), "name");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("objective"), "objective");
        }

        public static class CampaignCreationException extends APIRequestException {
            public CampaignCreationException() {
            }

            public CampaignCreationException(String s) {
                super(s);
            }

            public CampaignCreationException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignCreationException(Throwable throwable) {
                super(throwable);
            }

            public CampaignCreationException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIUpdateCampaign extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private final NextDoorAPICampaign nextDoorAPICampaign;
        private final String campaignId;

        public NextDoorAPIUpdateCampaign(NextDoorAPICampaign nextDoorAPICampaign, String campaignId) {
            super(Campaign.class, nextDoorAPICampaign.getNextDoorAPIAuth());

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
        public Campaign execute() throws APIRequestException {
            this.setParamInternal("advertiser_id", this.nextDoorAPICampaign.getAdvertiserId());
            this.setParamInternal("id", this.campaignId);

            validateRequiredParams();

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                if (this.containsParamInternal("user_status") && !this.containsParamInternal("objective")) {
                    validateParams("user_status");
                    return sendHttpRequest(HttpMethod.POST, updateStatusPath(), ConversionType.JSON);
                } else if (!this.containsParamInternal("user_status") && this.containsParamInternal("objective")) {
                    validateParams("objective", "name");

                    return sendHttpRequest(HttpMethod.POST, getPath(), ConversionType.JSON);
                }

                validateParams("objective", "name", "user_status");

                sendHttpRequest(HttpMethod.POST, getPath(), ConversionType.JSON);
                return sendHttpRequest(HttpMethod.POST, updateStatusPath(), ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignUpdateException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/update";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("id"), "id");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("advertiser_id"), "id");
        }

        private String updateStatusPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/status/update";
        }

        public static class CampaignUpdateException extends APIRequestException {
            public CampaignUpdateException() {
            }

            public CampaignUpdateException(String s) {
                super(s);
            }

            public CampaignUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignUpdateException(Throwable throwable) {
                super(throwable);
            }

            public CampaignUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}