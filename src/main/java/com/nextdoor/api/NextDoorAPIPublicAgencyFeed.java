package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.ConversionType;
import com.nextdoor.models.LocationListByState;
import com.nextdoor.models.Posts;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;
import com.nextdoor.util.NextDoorUtil;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_URL;

public class NextDoorAPIPublicAgencyFeed extends NextDoorAPIRequestNode {
    public NextDoorAPIPublicAgencyFeed() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIPublicAgencyFeed(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public static class NextDoorAPIAgencyListByState extends NextDoorAPIRequest<LocationListByState> implements NextDoorAPIExecute<LocationListByState> {
        private String stateId;

        public NextDoorAPIAgencyListByState(NextDoorAPIAuth nextDoorAPIAuth) {
            super(LocationListByState.class, nextDoorAPIAuth);

            this.addHeader(nextDoorAPIAuth.getTokenHeader());
        }

        public NextDoorAPIAgencyListByState setStateId(String stateId) {
            this.stateId = stateId;

            return this;
        }

        @Override
        protected String getPath() {
            return DEFAULT_URL + "partner_api/v1/agency_list/" + this.stateId;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.stateId, "stateID");
        }

        @Override
        public LocationListByState execute() throws APIRequestException {
            validateRequiredParams();

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new NextDoorAPICampaign.NextDoorAPICreateCampaign.CampaignCreationException("Can't create campaign, because of: " + e.getLocalizedMessage());
            }
        }
    }
}
