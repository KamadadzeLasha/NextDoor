package com.nextdoor.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpMethod;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.api.share.NextDoorAPICreate;
import com.nextdoor.api.share.NextDoorAPIRequest;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.CampaignCreationException;
import com.nextdoor.models.Advertiser;
import com.nextdoor.util.NextDoorUtil;

public class NextDoorAPIAdvertiser extends NextDoorAPIRequestNode {
    public NextDoorAPIAdvertiser() {

    }

    public NextDoorAPIAdvertiser(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateAdvertiser createAdvertiser() {
        return new NextDoorAPICreateAdvertiser(this.nextDoorAPIAuth, this);
    }

    public static class NextDoorAPICreateAdvertiser extends NextDoorAPIRequest<Advertiser> implements NextDoorAPICreate<Advertiser> {
        private final NextDoorAPIAdvertiser nextDoorAPIAdvertiser;

        public NextDoorAPICreateAdvertiser(NextDoorAPIAuth nextDoorAPIAuth, NextDoorAPIAdvertiser nextDoorAPIAdvertiser) {
            super(Advertiser.class, nextDoorAPIAuth);

            this.nextDoorAPIAdvertiser = nextDoorAPIAdvertiser;
        }

        public NextDoorAPICreateAdvertiser name(String name) {
            this.setParamInternal("name", name);

            return this;
        }

        public NextDoorAPICreateAdvertiser websiteUrl(String websiteUrl) {
            this.setParamInternal("website_url", websiteUrl);

            return this;
        }

        public NextDoorAPICreateAdvertiser categoryId(String categoryId) {
            this.setParamInternal("category_id", categoryId);

            return this;
        }

        public NextDoorAPICreateAdvertiser address(Advertiser.Address address) {
            this.setParamInternal("address", address);

            return this;
        }

        @Override
        public Advertiser create() throws CampaignCreationException {
            validateRequiredParams();

            this.addHeader(this.nextDoorAPIAdvertiser.nextDoorAPIAuth.getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (UnirestException | JsonProcessingException | APIRequestException e) {
                throw new CampaignCreationException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_API_URL + "advertiser/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureObjectNotNull(this.getParamInternal("name"), "name");
        }
    }
}
