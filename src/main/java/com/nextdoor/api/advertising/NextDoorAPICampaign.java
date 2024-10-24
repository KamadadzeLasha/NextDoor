package com.nextdoor.api.advertising;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Campaign;
import com.nextdoor.models.ConversionType;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
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
        return new NextDoorAPICreateCampaign(this.getNextDoorAPIAuth(), this.advertiserId);
    }

    public NextDoorAPIUpdateCampaign updateCampaign(String campaignId) {
        return new NextDoorAPIUpdateCampaign(this.getNextDoorAPIAuth(), campaignId, this.advertiserId);
    }

    public NextDoorAPIUpdateCampaignStatus updateCampaignStatus(String campaignId) {
        return new NextDoorAPIUpdateCampaignStatus(this.getNextDoorAPIAuth(), campaignId, this.advertiserId);
    }

    public static class NextDoorAPICreateCampaign extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private final String advertiserId;

        public NextDoorAPICreateCampaign(NextDoorAPIAuth nextDoorAPIAuth, String advertiserId) {
            super(Campaign.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");

            this.setParamInternal("advertiser_id", advertiserId);
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
            this.advertiserId = advertiserId;
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
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignCreationException("Can't create campaign for advertiser " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/create";
        }

        @Override
        protected void validateRequiredParams() {
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
        private final String campaignId;
        private final String advertiserId;

        public NextDoorAPIUpdateCampaign(NextDoorAPIAuth nextDoorAPIAuth, String campaignId, String advertiserId) {
            super(Campaign.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(campaignId, "campaignId");
            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");

            this.setParamInternal("id", campaignId);
            this.setParamInternal("advertiser_id", advertiserId);

            this.campaignId = campaignId;
            this.advertiserId = advertiserId;
        }

        public NextDoorAPIUpdateCampaign setName(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPIUpdateCampaign setObjective(Campaign.Objective objective) {
            this.setParamInternal("objective", objective.name());

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/update";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("name"), "name");
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("objective"), "objective");
        }

        @Override
        public Campaign execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignUpdateException("Can't update campaign (" + this.campaignId + ") for advertiser " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
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

    public static class NextDoorAPIUpdateCampaignStatus extends NextDoorAPIRequest<Campaign> implements NextDoorAPIExecute<Campaign> {
        private final String campaignId;
        private final String advertiserId;

        public NextDoorAPIUpdateCampaignStatus(NextDoorAPIAuth nextDoorAPIAuth, String campaignId, String advertiserId) {
            super(Campaign.class, nextDoorAPIAuth);

            NextDoorUtil.ensureStringNotNull(campaignId, "campaignId");
            NextDoorUtil.ensureStringNotNull(advertiserId, "advertiserId");

            this.setParamInternal("id", campaignId);
            this.setParamInternal("advertiser_id", advertiserId);

            this.campaignId = campaignId;
            this.advertiserId = advertiserId;
        }

        public NextDoorAPIUpdateCampaignStatus setUserStatus(Campaign.UserStatus userStatus) {
            this.setParamInternal("user_status", userStatus.name());

            return this;
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + "campaign/status/update";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("user_status"), "user_status");
        }

        @Override
        public Campaign execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CampaignStatusUpdateException("Can't update campaign (" + this.campaignId + ") status for advertiser " + this.advertiserId + ", because of: " + e.getLocalizedMessage());
            }
        }

        public static class CampaignStatusUpdateException extends APIRequestException {
            public CampaignStatusUpdateException() {
            }

            public CampaignStatusUpdateException(String s) {
                super(s);
            }

            public CampaignStatusUpdateException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CampaignStatusUpdateException(Throwable throwable) {
                super(throwable);
            }

            public CampaignStatusUpdateException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}