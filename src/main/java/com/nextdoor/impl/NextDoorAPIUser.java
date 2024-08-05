package com.nextdoor.impl;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.api.share.NextDoorAPIRequest;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.exception.CampaignCreationException;
import com.nextdoor.models.NextDoorUser;

public class NextDoorAPIUser extends NextDoorAPIRequestNode {
    public NextDoorAPIUser() {

    }

    public NextDoorAPIUser(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIUserInfo getUserInfo() {
        return new NextDoorAPIUserInfo(this.nextDoorAPIAuth, this);
    }

    public static class NextDoorAPIUserInfo extends NextDoorAPIRequest<NextDoorUser> {
        private final NextDoorAPIUser nextDoorAPIUser;

        public NextDoorAPIUserInfo(NextDoorAPIAuth nextDoorAPIAuth, NextDoorAPIUser nextDoorAPIUser) {
            super(NextDoorUser.class, nextDoorAPIAuth);

            this.nextDoorAPIUser = nextDoorAPIUser;
        }

        public NextDoorUser get() throws CampaignCreationException {
            this.addHeader(this.nextDoorAPIUser.nextDoorAPIAuth.getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.GET, getPath());
            } catch (APIRequestException e) {
                throw new CampaignCreationException("Can't get user info, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_API_URL + "me";
        }

        @Override
        protected void validateRequiredParams() {

        }
    }
}
