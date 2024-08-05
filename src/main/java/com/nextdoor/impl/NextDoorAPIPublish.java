package com.nextdoor.impl;

import com.nextdoor.api.response.NextDoorAPIRequestNode;
import com.nextdoor.api.share.NextDoorAPIGet;
import com.nextdoor.api.share.NextDoorAPIRequest;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Profile;

public class NextDoorAPIPublish extends NextDoorAPIRequestNode {
    public NextDoorAPIPublish() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIPublish(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIPublishProfileInfo getProfileInfo() {
        return new NextDoorAPIPublishProfileInfo(this);
    }

    public static class NextDoorAPIPublishProfileInfo extends NextDoorAPIRequest<Profile> implements NextDoorAPIGet<Profile> {
        private final NextDoorAPIPublish nextDoorAPIPublish;

        public NextDoorAPIPublishProfileInfo(NextDoorAPIPublish nextDoorAPIPublish) {
            super(Profile.class, nextDoorAPIPublish.nextDoorAPIAuth);

            this.nextDoorAPIPublish = nextDoorAPIPublish;
        }

        @Override
        public Profile get() throws APIRequestException {
            return null;
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }
    }
}
